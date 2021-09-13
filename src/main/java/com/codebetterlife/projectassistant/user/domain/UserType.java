package com.codebetterlife.projectassistant.user.domain;

import java.util.Arrays;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-13 4:03 下午
 */
public enum UserType {

    /**
     * 用户类型
     */
    WORKER, MANAGER, ADMIN;

    static UserType get(String value) {
        return Arrays.stream(UserType.values()).filter(o -> o.name().equals(value)).findFirst().orElse(null);
    }
}
