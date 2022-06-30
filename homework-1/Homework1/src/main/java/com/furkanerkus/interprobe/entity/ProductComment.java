package com.furkanerkus.interprobe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUCT_COMMENTS")
@Getter
@Setter
public class ProductComment extends BaseEntity{

    @Id
    @GeneratedValue(generator = "ProductComment", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ProductComment", sequenceName = "PRODUCT_COMMENT_ID_SEQ")
    private Long id;

    @Column(name = "COMMENT", length = 500, nullable = false)
    private String comment;

    @Column(name = "COMMENT_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date commentDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false,
            foreignKey = @ForeignKey(name = "FK_PRODUCT_COMMENT_PRODUCT",value = ConstraintMode.CONSTRAINT))
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false,
            foreignKey = @ForeignKey(name = "FK_PRODUCT_COMMENT_USER", value = ConstraintMode.CONSTRAINT))
    private User user;

}
