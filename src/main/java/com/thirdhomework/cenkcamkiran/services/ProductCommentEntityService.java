package com.thirdhomework.cenkcamkiran.services;

import java.util.List;
import java.util.Optional;

import com.thirdhomework.cenkcamkiran.entities.ProductComment;
import com.thirdhomework.cenkcamkiran.repository.ProductCommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCommentEntityService {
    @Autowired
    private ProductCommentRepository productCommentRepository;

    public List<ProductComment> findAll() {
        return productCommentRepository.findAll();
    }

    public ProductComment save(ProductComment category) {
        return productCommentRepository.save(category);
    }

    public ProductComment findById(String id) {

        Optional<ProductComment> optional = productCommentRepository.findById(id);

        ProductComment ProductComment = null;
        if (optional.isPresent()) {
            ProductComment = optional.get();
        }

        return ProductComment;
    }

    public void deleteById(String id) {
        productCommentRepository.deleteById(id);
    }
}
