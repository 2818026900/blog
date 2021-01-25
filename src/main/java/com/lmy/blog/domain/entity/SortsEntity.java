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
@Entity(name = "com.lmy.blog.domain.entity.SortsEntity")
@Table(name = "sorts", uniqueConstraints = {
        @UniqueConstraint(columnNames = "sort_id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SortsEntity {

    /**
     * 分类编号
     */
    @Id
    @Column(name = "sort_id",nullable = false)
    private BigInteger sortId;

    /**
     * 分类名
     */
    @Column(name = "sort_name",nullable = false)
    private String sortName;

    /**
     * 分类别名
     */
    @Column(name = "sort_alias",nullable = false)
    private String sortAlias;

    /**
     * 分类描述
     */
    @Column(name = "sort_description",nullable = false)
    private String sortDescription;

    /**
     * 父分类id
     */
    @Column(name = "parent_sort_id",nullable = false)
    private BigInteger parentSortId;
}
