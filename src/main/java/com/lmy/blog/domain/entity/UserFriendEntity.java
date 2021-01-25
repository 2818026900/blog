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
@Entity(name = "com.lmy.blog.domain.UserFriendEntity")
@Table(name = "user_Friends",uniqueConstraints = {
        @UniqueConstraint(columnNames =  "id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFriendEntity {
    /**
     * 好友标识id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private BigInteger id;

    /**
     * 用户id
     */
    @Column(name = "user_id",nullable = false)
    private BigInteger userId;

    /**
     * 用户好友id
     */
    @Column(name = "user_friends_id",nullable = false)
    private BigInteger userFriendsId;

    /**
     * 好友备注
     */
    @Column(name = "user_note",nullable = false)
    private String userNote;

    /**
     * 好友状态
     */
    @Column(name = "user_status",nullable = false)
    private String userStatus;
}
