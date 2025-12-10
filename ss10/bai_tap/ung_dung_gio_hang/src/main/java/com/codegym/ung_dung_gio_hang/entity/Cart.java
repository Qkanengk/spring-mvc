package com.codegym.ung_dung_gio_hang.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    // ... Constructor và Getter giữ nguyên

    // Logic thêm sản phẩm đã được tối ưu
    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            // Nếu có rồi thì tăng số lượng
            Integer currentQuantity = products.get(product);
            products.replace(product, currentQuantity + 1);
        } else {
            // Nếu chưa có thì thêm mới
            products.put(product, 1);
        }
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    // Hàm này để giảm số lượng hoặc xóa (bổ sung thêm cho bạn)
    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
            Integer currentQuantity = products.get(product);
            if (currentQuantity > 1) {
                products.replace(product, currentQuantity - 1);
            } else {
                products.remove(product);
            }
        }
    }

    public Integer countProductQuantity() {
        // Dùng Stream API cho ngắn (Java 8+)
        return products.values().stream().mapToInt(Integer::intValue).sum();

        // Hoặc giữ nguyên code cũ của bạn cũng tốt, dễ hiểu
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Double countTotalPayment() { // Đổi sang Double
        double payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }
}