package service;

import modul.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    // tạo một danh sách đối tượng product
    private static Map<Integer, Product> products;
    static {
       products = new HashMap<>();
       products.put(1,new Product(1,"iphone",120,"like new"));
       products.put(2,new Product(2,"samsung",121,"like new"));
       products.put(3,new Product(3,"huwai",122,"like new"));
       products.put(4,new Product(4,"xiaomi",123,"like new"));
       products.put(5,new Product(5,"nokia",124,"like new"));
    }
    @Override
    public List<Product> findAll() {
        // trả về 1 danh sách mới các sản phẩm là giá trị value của danh sách productMap
        return new ArrayList<Product>(products.values());
    }

    @Override
    public Product save(Product product) {
        return products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product updater(int id, Product product) {
        return products.replace(id,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }
}
