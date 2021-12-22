package com.thirdhomework.cenkcamkiran.controllers;

import java.util.List;

import com.thirdhomework.cenkcamkiran.entities.ProductComment;
import com.thirdhomework.cenkcamkiran.exception.ProductCommentException;
import com.thirdhomework.cenkcamkiran.services.ProductCommentEntityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productComments")
public class ProductCommentController {
    @Autowired
    private ProductCommentEntityService productCommentEntityService;

    @GetMapping("")
    public List<ProductComment> findAll() {

        List<ProductComment> ProductComment = productCommentEntityService.findAll();

        if (ProductComment == null || ProductComment.size() == 0) {
            throw new ProductCommentException("Kayıtlı herhangi bir yorum yoktur.");
        }

        return productCommentEntityService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ProductComment ProductComment) {

        ProductComment = productCommentEntityService.save(ProductComment);

        if (ProductComment == null) {
            throw new ProductCommentException("Yorumu kaydederken hata meydana geldi.");
        }

        return new ResponseEntity<>(ProductComment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ProductComment findById(@PathVariable String id) {

        ProductComment ProductComment = productCommentEntityService.findById(id);

        if (ProductComment == null) {
            throw new ProductCommentException(id + " ID li yorum yoktur.");
        }

        return ProductComment;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        productCommentEntityService.deleteById(id);
    }
}
