package com.codebetterlife.projectassistant.base.service;

import com.codebetterlife.projectassistant.base.domain.BaseDomain;
import com.codebetterlife.projectassistant.base.domain.criteria.BaseCriteria;
import com.codebetterlife.projectassistant.base.repository.BaseRepository;
import com.codebetterlife.projectassistant.base.repository.SpecificationBuilder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-01 6:35 下午
 */
public interface BaseService<T extends BaseDomain, ID> {

    /**
     * 获取Repository
     *
     * @return Repository
     */
    BaseRepository<T, ID> getRepository();

    /**
     * 逻辑删除
     *
     * @param id 主键
     */
    default void deleteLogic(ID id) {
        Optional<T> optional = getRepository().findById(id);
        optional.ifPresent(o -> {
            o.setDelFlag(((byte) 1));
            o.setUpdateTime(LocalDateTime.now());
            getRepository().save(o);
        });
    }

    /**
     * 根据ID查询
     *
     * @param id 主键
     * @return 查询结果Optional
     */
    default Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    /**
     * 分页查询
     *
     * @param example  example
     * @param pageable 分页信息
     * @return 分页数据
     */
    default Page<T> findByPage(Example<T> example, Pageable pageable) {
        example.getProbe().setDelFlag((byte) 0);
        return getRepository().findAll(example, pageable);
    }

    /**
     * 分页查询
     *
     * @param baseCriteria baseCriteria
     * @param pageable     分页信息
     * @return 分页数据
     */
    default Page<T> findByPage(BaseCriteria baseCriteria, Pageable pageable) {
        return getRepository().findAll(new SpecificationBuilder<>(baseCriteria), pageable);
    }

    /**
     * 保存
     *
     * @param t 保存对象
     * @return 已保存对象
     */
    default T save(T t) {
        t.setDelFlag((byte) 0);
        t.setCreateTime(LocalDateTime.now());
        return getRepository().save(t);
    }

    /**
     * 更新
     *
     * @param t 更新对象
     * @return 已更新对象
     */
    default T update(T t) {
        t.setUpdateTime(LocalDateTime.now());
        return getRepository().save(t);
    }
}
