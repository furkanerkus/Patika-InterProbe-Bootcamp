package com.furkanerkus.interprobe.dao;

import com.furkanerkus.interprobe.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductCommentDao extends JpaRepository<ProductComment, Long> {

    List<ProductComment> findAllByProduct_Id (Long productId);

    List<ProductComment> findAllByProduct_IdAndCommentDateBetween (Long id, Date from, Date to);

    List<ProductComment> findAllByUser_Id(Long userId);

    List<ProductComment> findAllByUser_IdAndCommentDateBetween (Long id, Date from, Date to);

}
