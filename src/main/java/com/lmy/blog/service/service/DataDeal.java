package com.lmy.blog.service.service;

import com.lmy.blog.domain.entity.ArticlesEntity;
import com.lmy.blog.domain.entity.LabelsEntity;
import com.lmy.blog.domain.entity.UsersEntity;
import com.lmy.blog.domain.repository.ArticlesRepository;
import com.lmy.blog.domain.repository.LabelsRepository;
import com.lmy.blog.domain.repository.UsersRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lmy
 * @email 2818026900@qq.com
 */
@NoArgsConstructor
public class DataDeal {
    private UsersRepository usersRepository;
    private LabelsRepository labelsRepository;
    private ArticlesRepository articlesRepository;

    String userFlag = "failed", labelFlag = "failed", articleFlag = "failed";

    @Autowired
    public DataDeal(LabelsRepository labelsRepository, UsersRepository usersRepository, ArticlesRepository articlesRepository) {
        this.labelsRepository = labelsRepository;
        this.usersRepository = usersRepository;
        this.articlesRepository = articlesRepository;
    }

    /**
     * 将前端传回的字符串数据内容补全并保存到数据库
     * @param articles 前端发送的数据不完整的文章实体
     * @return 保存成功”success“
     */
    public String articlesDataDeal(ArticlesEntity articles){
        ArticlesEntity articlesEntity = articlesRepository.findByArAndArticleId(articles.getArticleId());
        if(articles.getUserId()==null){
            articles.setUserId(articlesEntity.getUserId());
        }
        return articleFlag;
    }

    /**
     * 将前端传回的字符串数据内容补全并保存到数据库
     * @param users 前端发送的数据不完整的用户实体
     * @return 保存成功”success“
     */
    public String userDataDeal(UsersEntity users){
        UsersEntity usersEntity = usersRepository.findByUserId(users.getUserId());
        if(users.getUserIp()==null) {
            users.setUserIp(usersEntity.getUserIp());
        }
        if(users.getUserName()==null) {
            users.setUserName(usersEntity.getUserName());
        }
        if(users.getUserPassword()==null) {
            users.setUserPassword(usersEntity.getUserPassword());
        }
        if(users.getUserEmail()==null) {
            users.setUserEmail(usersEntity.getUserEmail());
        }
        if(users.getUserProfilePhoto()==null) {
            users.setUserProfilePhoto(usersEntity.getUserProfilePhoto());
        }
        if(users.getUserRegistrationTime()==null) {
            users.setUserRegistrationTime(usersEntity.getUserRegistrationTime());
        }
        if(users.getUserBirthday()==null) {
            users.setUserBirthday(usersEntity.getUserBirthday());
        }
        if(users.getUserAge()==null) {
            users.setUserAge(usersEntity.getUserAge());
        }
        if(String.valueOf(users.getUserTelephoneNumber())==null) {
            users.setUserTelephoneNumber(usersEntity.getUserTelephoneNumber());
        }
        if(users.getUserNickname()==null) {
            users.setUserNickname(usersEntity.getUserNickname());
        }
        UsersEntity u = usersRepository.saveAndFlush(users);
        if(u.equals(users)){
            userFlag = "success";
        }else {
            userFlag = "failed";
        }
        return userFlag;
    }

    /**
     * 将前端传回的字符串数据内容补全并保存到数据库
     * @param labels 前端发送的数据不完整的标签实体
     * @return 保存成功”success“
     */
    public String labelsDataDeal(LabelsEntity labels){
        LabelsEntity labelsEntity = labelsRepository.findByLabelId(labels.getLabelId());
        if(labels.getLabelName()==null){
            labels.setLabelName(labelsEntity.getLabelName());
        }
        if(labels.getLabelAlias()==null){
            labels.setLabelAlias(labelsEntity.getLabelAlias());
        }
        if(labels.getLabelDescription()==null){
            labels.setLabelDescription(labelsEntity.getLabelDescription());
        }
        LabelsEntity l =labelsRepository.saveAndFlush(labels);
        if(l.equals(labels)){
            labelFlag = "success";
        }else {
            labelFlag = "failed";
        }
        return labelFlag;
    }
}
