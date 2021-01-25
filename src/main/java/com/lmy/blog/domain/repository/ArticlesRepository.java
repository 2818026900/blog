package com.lmy.blog.domain.repository;

import com.lmy.blog.domain.entity.ArticlesEntity;

import java.math.BigInteger;

/**
 * @author lmy
 */
public interface ArticlesRepository extends BaseRepository<ArticlesEntity, BigInteger>{

    /**
     * 通过id查询
     * @param id id号
     * @return UsersEntity
     */
    ArticlesEntity findByArAndArticleId(BigInteger id);
}
