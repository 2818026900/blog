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
@Entity(name = "com.lmy.blog.domain.entity.LabelsEntity")
@Table(name = "labels", uniqueConstraints = {
        @UniqueConstraint(columnNames = "label_id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabelsEntity {

    /**
     * 标签id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_id",nullable = false)
    private BigInteger labelId;

    /**
     * 标签名
     */
    @Column(name = "label_name",nullable = false,length = 20)
    private String labelName;

    /**
     * 标签别名
     */
    @Column(name = "label_alias",nullable = false,length = 15)
    private String labelAlias;

    /**
     * 标签描述
     */
    @Column(name = "label_description",nullable = false)
    private String labelDescription;
}
