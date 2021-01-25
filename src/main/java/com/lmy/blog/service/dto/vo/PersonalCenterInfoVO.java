package com.lmy.blog.service.dto.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;


/**
 * @author lmy
 */
@Data
public class PersonalCenterInfoVO {
    private String userId;
    private String userName;
    private String userEmail;
    private String userProfilePhoto;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp userRegistrationTime;
    private Date userBirthday;
    private String userAge;
    private String userTelephoneNumber;
    private String userNickname;
    private String labelId;
    private String labelName;
}
