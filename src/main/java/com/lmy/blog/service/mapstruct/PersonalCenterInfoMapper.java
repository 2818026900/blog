package com.lmy.blog.service.mapstruct;

import com.lmy.blog.domain.entity.LabelsEntity;
import com.lmy.blog.domain.entity.UsersEntity;
import com.lmy.blog.service.dto.vo.PersonalCenterInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author lmy
 */
@Mapper
public interface PersonalCenterInfoMapper {
    /**
     * 获取该类自动生成的实现类的实例
     * 接口中的属性都是 public static final 的 方法都是public abstract的
     */
    PersonalCenterInfoMapper INSTANCES = Mappers.getMapper(PersonalCenterInfoMapper.class);

    /**
     * 这个方法就是用于实现对象属性复制的方法
     *
     * @Mapping 用来定义属性复制规则 source 指定源对象属性 target指定目标对象属性
     *
     * 这个参数就是源对象，也就是需要被复制的对象
     * @param usersEntity 用户
     * @param labelsEntity 标签
     * @return 返回的是目标对象，就是最终的结果对象
     */
    @Mappings({
            @Mapping(source = "usersEntity.userId", target = "userId"),
            @Mapping(source = "usersEntity.userName", target = "userName"),
            @Mapping(source = "usersEntity.userEmail", target = "userEmail"),
            @Mapping(source = "usersEntity.userProfilePhoto", target = "userProfilePhoto"),
            @Mapping(source = "usersEntity.userRegistrationTime", target = "userRegistrationTime",dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "usersEntity.userBirthday", target = "userBirthday",dateFormat = "yyyy-MM-dd"),
            @Mapping(source = "usersEntity.userAge", target = "userAge"),
            @Mapping(source = "usersEntity.userTelephoneNumber", target = "userTelephoneNumber"),
            @Mapping(source = "usersEntity.userNickname", target = "userNickname"),
            @Mapping(source = "labelsEntity.labelId", target = "labelId"),
            @Mapping(source = "labelsEntity.labelName", target = "labelName")
    })
    PersonalCenterInfoVO toPersonalCenterInfoVo(UsersEntity usersEntity, LabelsEntity labelsEntity);
}
