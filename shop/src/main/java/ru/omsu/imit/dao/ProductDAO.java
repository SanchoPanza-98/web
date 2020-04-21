package ru.omsu.imit.dao;

import ru.omsu.imit.model.Product;
import java.util.List;

public interface ProductDAO {

    Product insert(Product product);
    void deleteAll();
    Product getById(int id);
    List<Product> getByCost (int cost);
    List<Product> getByProductName(String productName);
    List<Product> getAllLazy();
    void delete (int id);
    Product updateProduct(Product product);
}
