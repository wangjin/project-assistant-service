package com.codebetterlife.projectassistant.user.service.impl;

import com.codebetterlife.projectassistant.base.repository.BaseRepository;
import com.codebetterlife.projectassistant.user.domain.User;
import com.codebetterlife.projectassistant.user.repository.UserRepository;
import com.codebetterlife.projectassistant.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-01 7:55 下午
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public BaseRepository<User, Long> getRepository() {
        return userRepository;
    }
}
