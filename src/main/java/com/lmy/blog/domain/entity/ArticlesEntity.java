package com.lmy.blog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;


/**
 * @author lmy
 * @email 2818026900@qq.com
 */
@Entity(name = "com.lmy.blog.domain.entity.ArticlesEntity")
@Table(name = "articles", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticlesEntity {

    /**
     * 文章id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id",nullable = false)
    private BigInteger articleId;

    /**
     * 用户id
     */
    @Column(name = "user_id",nullable = false)
    private BigInteger userId;

    /**
     * 文章标题
     */
    @Column(name = "article_title",nullable = false)
    private String articleTitle;

    /**
     * 文章内容
     */
    @Column(name = "article_content",nullable = false)
    private String articleContent;

    /**
     * 文章视图
     */
    @Column(name = "article_views",nullable = false)
    private BigInteger articleViews;

    /**
     * 文章评论数
     */
    @Column(name = "article_comment_count",nullable = false)
    private BigInteger articleCommentCount;

    /**
     * 文章日期
     */
    @Column(name = "article_date")
    private Timestamp articleDate;

    /**
     * 文章喜欢数
     */
    @Column(name = "article_like_count",nullable = false)
    private BigInteger articleLikeCount;
}
