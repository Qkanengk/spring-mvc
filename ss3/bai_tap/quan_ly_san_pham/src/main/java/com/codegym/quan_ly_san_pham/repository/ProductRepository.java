package com.codegym.quan_ly_san_pham.repository;

import com.codegym.quan_ly_san_pham.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void update(int id, Product product) {
        Product product1 = findById(id);
        if (product1 != null) {
            product1.setName(product.getName());
            entityManager.merge(product1);
        }
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}
