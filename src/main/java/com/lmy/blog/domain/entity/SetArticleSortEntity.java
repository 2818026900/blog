package com.lmy.blog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * @author lmy
 * @email 2818026900@qq.com
 */
@Entity(name = "com.lmy.blog.domain.SetArticleSortEntity")
@Table(name = "set_article_sort",uniqueConstraints = {
        @UniqueConstraint(columnNames =  "article_id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetArticleSortEntity {

    /**
     * 文章id
     */
    @Id
    @Column(name = "article_id",nullable = false)
    private BigInteger articleId;

    /**
     * 分类id
     */
    @Column(name = "sort_id",nullable = false)
    private BigInteger sortId;
}
