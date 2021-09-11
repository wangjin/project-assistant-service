package com.codebetterlife.projectassistant.base.repository;

import com.codebetterlife.projectassistant.base.domain.BaseDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-01 7:21 下午
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseDomain, ID> extends JpaRepository<T, ID> {

}
