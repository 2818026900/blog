package com.lmy.blog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;


/**
 * @author lmy
 *
 * @email 2818026900@qq.com
 */
@Entity(name = "com.lmy.blog.domain.UserEntity")
@Table(name = "users",uniqueConstraints = {
        @UniqueConstraint(columnNames =  "user_id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersEntity {

    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private BigInteger userId;

    /**
     * 用户ip
     */
    @Column(name = "user_ip",nullable = false,length = 20)
    private String userIp;

    /**
     * 用户名
     */
    @Column(name = "user_name",nullable = false,length = 20)
    private String userName;

    /**
     * 用户密码
     */
    @Column(name = "user_password",nullable = false,length = 15)
    private String userPassword;

    /**
     * 用户邮箱
     */
    @Column(name = "user_email",nullable = false,length = 30)
    private String userEmail;

    /**
     * 用户个人资料照片
     */
    @Column(name = "user_profile_photo",nullable = false)
    private String userProfilePhoto;

    /**
     * 用户注册时间
     */
    @Column(name = "user_registration_time")
    private Timestamp userRegistrationTime;

    /**
     * 用户生日
     */
    @Column(name = "user_birthday")
    private Date userBirthday;

    /**
     * 用户年龄
     */
    @Column(name = "user_age")
    private Integer userAge;

    /**
     * 用户手机号
     */
    @Column(name = "user_telephone_number",nullable = false)
    private int userTelephoneNumber;

    /**
     * 用户昵称
     */
    @Column(name = "user_nickname",nullable = false,length = 20)
    private String userNickname;
}
