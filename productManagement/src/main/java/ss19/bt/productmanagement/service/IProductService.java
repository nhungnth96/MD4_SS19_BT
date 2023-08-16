package ss19.bt.productmanagement.service;


import ss19.bt.productmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void remove(int id);

}
