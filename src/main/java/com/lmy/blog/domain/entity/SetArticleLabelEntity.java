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
@Entity(name = "com.lmy.blog.domain.SetArticleLabelEntity")
@Table(name = "set_article_label",uniqueConstraints = {
        @UniqueConstraint(columnNames =  "article_id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetArticleLabelEntity {

    /**
     * 文章id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id",nullable = false)
    private BigInteger articleId;

    /**
     * 标签id
     */
    @Column(name = "label_id",nullable = false)
    private BigInteger labelId;
}
