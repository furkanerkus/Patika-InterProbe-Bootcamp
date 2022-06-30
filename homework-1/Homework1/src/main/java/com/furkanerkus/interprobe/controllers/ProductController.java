package com.furkanerkus.interprobe.controllers;

import com.furkanerkus.interprobe.dao.ProductDao;
import com.furkanerkus.interprobe.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductDao productDao;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productDao.save(product);
    }


    @GetMapping("/showAllProducts")
    public List<Product> showAllProducts() {
        return productDao.findAll();
    }

    @GetMapping("/findAllByExpireDateLessThan")
    public List<Product> findAllByExpireDateLessThan(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return productDao.findAllByExpireDateLessThan(date);
    }

    @GetMapping("/findAllByExpireDateGreaterThanEqualOrExpireDateIsNull")
    public List<Product> findAllByExpireDateGreaterThanEqualOrExpireDateIsNull(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return productDao.findAllByExpireDateGreaterThanEqualOrExpireDateIsNull(date);
    }

}