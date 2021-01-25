package com.lmy.blog.domain.repository;

import com.lmy.blog.domain.entity.LabelsEntity;
import com.lmy.blog.domain.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * @author lmy
 * @email 2818026900@qq.com
 */
@Repository("com.lmy.blog.domain.repository.manager.LabelsManager")
public interface LabelsRepository extends BaseRepository<LabelsEntity, BigInteger> {
    /**
     *
     * 通过id号查询labels
     * @param Id 标签编号
     * @return LabelsEntity
     */
    LabelsEntity findByLabelId(BigInteger Id);
}
