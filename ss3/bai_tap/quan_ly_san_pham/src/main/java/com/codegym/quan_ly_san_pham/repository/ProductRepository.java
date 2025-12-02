package com.codegym.quan_ly_san_pham.repository;

import com.codegym.quan_ly_san_pham.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Táo"));
        products.add(new Product(2, "Ổi"));
        products.add(new Product(3, "Xoài"));
        products.add(new Product(4, "Mận"));
        products.add(new Product(5, "Đào"));
        products.add(new Product(6, "Dâu"));
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) return product;
            //return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null)
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        Product product1 = findById(id);
        product1.setName(product.getName());
    }

    @Override
    public void remove(int id) {
        products.remove(findById(id));
    }
}
