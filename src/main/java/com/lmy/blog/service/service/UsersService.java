package com.lmy.blog.service.service;


import com.alibaba.fastjson.JSON;
import com.lmy.blog.domain.entity.LabelsEntity;
import com.lmy.blog.domain.entity.UsersEntity;
import com.lmy.blog.domain.repository.LabelsRepository;
import com.lmy.blog.domain.repository.UsersRepository;
import com.lmy.blog.service.dto.vo.PersonalCenterInfoVO;
import com.lmy.blog.service.mapstruct.PersonalCenterInfoMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.math.BigInteger;

/**
 * @author lmy
 * @email 2818026900@qq.com
 */
@Service
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class UsersService {

    private UsersRepository usersRepository;
    private LabelsRepository labelsRepository;

    @Autowired
    public UsersService(LabelsRepository labelsRepository, UsersRepository usersRepository) {
        this.labelsRepository = labelsRepository;
        this.usersRepository = usersRepository;
    }

    public PersonalCenterInfoVO e2vo(String username,BigInteger labelId){
        if (log.isDebugEnabled()) {
            log.debug("========================================");
            log.debug("parameter username is : {} ", username);
            log.debug("parameter labelId is : {} ", labelId);
        }
        try {
            UsersEntity usersEntity = usersRepository.findByUserName(username);
            LabelsEntity labelsEntity = labelsRepository.findByLabelId(labelId);
            PersonalCenterInfoVO personalCenterInfoVO = PersonalCenterInfoMapper.INSTANCES
                    .toPersonalCenterInfoVo(usersEntity,labelsEntity);
            return personalCenterInfoVO;

        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("exception message is {}", e.getMessage(), e);
            }
            throw e;
        }
    }

    public String jsonStr2e(String jsonStr){
        UsersEntity users = JSON.parseObject(jsonStr,UsersEntity.class);
        DataDeal dataDeal = new DataDeal();
        String userFlag = dataDeal.userDataDeal(users);

        LabelsEntity labels = JSON.parseObject(jsonStr,LabelsEntity.class);
        String labelFlag = dataDeal.labelsDataDeal(labels);
        if("success".equals(userFlag)&&"success".equals(labelFlag)){
            return "success";
        }
        return "failed";
    }

}
