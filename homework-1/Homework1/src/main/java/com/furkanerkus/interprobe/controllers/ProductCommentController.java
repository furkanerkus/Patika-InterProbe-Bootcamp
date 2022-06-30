package com.furkanerkus.interprobe.controllers;

import com.furkanerkus.interprobe.dao.ProductCommentDao;
import com.furkanerkus.interprobe.entity.ProductComment;
import lombok.RequiredArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/productcomments")
public class ProductCommentController {

    private final ProductCommentDao productCommentDao;

    @PostMapping
    public ProductComment addComment(@RequestBody ProductComment productComment) {
        return productCommentDao.save(productComment);
    }

    @GetMapping("/showAllComments")
    public List<ProductComment> showAllComments() {
        return productCommentDao.findAll();
    }

    @GetMapping("/showCommentsByProduct/{id}")
    public List<ProductComment> showCommentsByProduct(@PathVariable("Product Id: ") Long id) {
        return productCommentDao.findAllByProduct_Id(id);
    }


    @GetMapping("/showCommentsByProductAndDate")
    public List<ProductComment> showCommentsByProductAndDate(@RequestParam("product_id") Long id,
                                                                         @RequestParam("date from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
                                                                         @RequestParam("date to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
        return productCommentDao.findAllByProduct_IdAndCommentDateBetween(id, from, to);
    }


    @GetMapping("/showCommentsByUser")
    public List<ProductComment> showCommentsByUser(@RequestParam("user_id") Long id) {
        return productCommentDao.findAllByUser_Id(id);
    }

    @GetMapping("/showCommentsByUserIdAndDate")
    public List<ProductComment> showCommentsByUserIdAndDate(@RequestParam("user_id") Long id,
                                                                      @RequestParam("date from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
                                                                      @RequestParam("date to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to) {
        return productCommentDao.findAllByUser_IdAndCommentDateBetween(id, from, to);
    }
}
