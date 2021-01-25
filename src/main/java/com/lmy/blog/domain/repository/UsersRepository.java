package com.lmy.blog.domain.repository;

import com.lmy.blog.domain.entity.UsersEntity;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * @author lmy
 * @email 2818026900@qq.com
 */
@Repository("com.lmy.blog.domain.repository.manager.UserManager")
public interface UsersRepository extends BaseRepository<UsersEntity, BigInteger> {
    /**
     * 通过用户名查询
     * @param username 用户名
     * @return 返回用户实体
     */
    UsersEntity findByUserName(String username);

    /**
     * 通过id查询
     * @param id id号
     * @return UsersEntity
     */
    UsersEntity findByUserId(BigInteger id);
}
