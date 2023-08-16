package ss19.bt.productmanagement.service;



import ss19.bt.productmanagement.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        products.add(new Product(1,"Product 1",100,"Green","BMW"));
        products.add(new Product(2,"Product 2",200,"Blue","Audi"));
        products.add(new Product(3,"Product 3",300,"Red","Kia"));
        products.add(new Product(4,"Product 4",400,"Black","Hyundai"));
        products.add(new Product(5,"Product 5",500,"White","Toyota"));
    }

    @Override
    public List<Product> findAll() {
       return products;
    }
    @Override
    public void save(Product product) {

        if(product.getId()==0){
            product.setId(getNewId());
            products.add(product);
        } else {
            products.set(products.indexOf(findById(product.getId())),product);
        }
    }
    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {

        products.remove(findById(id));
    }

    public int getNewId(){
        int maxId = 0;
        for (Product product : products) {
            if(product.getId()>maxId){
                maxId = product.getId();
            }
        }
        return maxId+1;
    }
}
