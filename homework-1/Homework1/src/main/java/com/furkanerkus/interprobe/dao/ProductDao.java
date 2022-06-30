package com.furkanerkus.interprobe.dao;

import com.furkanerkus.interprobe.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface ProductDao extends JpaRepository<Product, Long> {

    public List<Product> findAllByExpireDateLessThan(Date date);

    public List<Product> findAllByExpireDateGreaterThanEqualOrExpireDateIsNull(Date date);


}
