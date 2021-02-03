package controller;

import modul.Product;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // b1 : đặt 1 biến để hấng action được lấy từ yêu cầu phía client /products?action=create
        String action = request.getParameter("action");
        // do ban đầu chưa có hành động nào khi chạy chương trình lên action = null lúc này ta sẽ gán action bằng "" để điều hướng về trang index.jsp
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showRemoveCustomer(request, response);
                break;
            case "detail":
                break;
            default:
                showAllProduct(request, response);
                break;
        }

    }

    private void showRemoveCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        // do edit phải có đối tượng và id lên ta sẽ lấy id và đối tượng từ sever
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        // điều hướng
        RequestDispatcher dispatcher;
        // nếu đối tượng null điều hướng đến trang thông báo lỗi
        if (product == null) {
            // set lại giá trị key value cho customer
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/updater.jsp");
        }
        // forward
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) {
        // lấy danh sách các sản phẩm ra
        List<Product> products = productService.findAll();
        // cài đặt lại thuộc tính danh sách để products xuất hiện bên jsp
        request.setAttribute("products", products);
        // điều hướng đến trang hiển thị bằng requestDispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        // tương tác giữa request và response
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        } else {
            switch (action) {
                case "create":
                    createCustomer(request, response);
                    break;
                case "edit":
                    editCustomer(request, response);
                    break;
                case "delete":
                    deleteCustomer(request,response);
                    break;
                case "detail":
                    break;
            }
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        Product product = new Product(id, name, price, description);
        productService.updater(id, product);
        // điều hướng nó về
        try {
            response.sendRedirect("/products");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int id = (int) Math.random() * 10000000;
        Product product = new Product(id, name, price, description);
        productService.save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
