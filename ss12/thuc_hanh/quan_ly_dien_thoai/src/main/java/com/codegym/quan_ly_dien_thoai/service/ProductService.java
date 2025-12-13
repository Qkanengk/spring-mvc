package com.codegym.quan_ly_dien_thoai.service;

import com.codegym.quan_ly_dien_thoai.entity.Product;
import com.codegym.quan_ly_dien_thoai.repository.IProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Integer id, Product product) {
        Product product1 = findById(id);
        if (product1 != null) {
            product1.setPrice(product.getPrice());
            product1.setModel(product.getModel());
            product1.setProducer(product.getProducer());
            return productRepository.save(product1);
        }
        return null;
    }


    @Override
    public void remove(Integer id) {
        productRepository.deleteById(id);
    }
}
