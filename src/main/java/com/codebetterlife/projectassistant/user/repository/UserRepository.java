package com.codebetterlife.projectassistant.user.repository;

import com.codebetterlife.projectassistant.base.repository.BaseRepository;
import com.codebetterlife.projectassistant.user.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-01 7:58 下午
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {
}
