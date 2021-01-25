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
@Entity(name = "com.lmy.blog.domain.CommentsEntity")
@Table(name = "comments",uniqueConstraints = {
        @UniqueConstraint(columnNames =  {"comment_id","user_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsEntity {

    /**
     * 评论id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id",nullable = false)
    private BigInteger commentId;

    /**
     * 用户id
     */
    @Column(name = "user_id",nullable = false)
    private BigInteger userId;

    /**
     * 文章id
     */
    @Column(name = "article_id",nullable = false)
    private BigInteger articleId;

    /**
     * 评论喜欢人数
     */
    @Column(name = "comment_like_count",nullable = false)
    private BigInteger commentLikeCount;

    /**
     * 评论日期
     */
    @Column(name = "comment_date")
    private Timestamp commentDate;

    /**
     * 评论内容
     */
    @Column(name = "comment_content",nullable = false)
    private String commentContent;

    /**
     * 父评论id
     */
    @Column(name = "parent_comment_id",nullable = false)
    private BigInteger parentCommentId;
}
