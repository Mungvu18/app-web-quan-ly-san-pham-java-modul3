package service;

import java.util.List;

public interface IGeneralService <T>{
   // thiết kế crul
    List<T> findAll();
    // phuong thức lưu đối tượng
    T save(T t);
    // phương thức tìm kiếm đối tượng
    T findById(int id);
    // phương thức chỉnh sửa đối tượng
    T updater(int id, T t);
    // xóa đối tượng
    void delete(int id);
}
