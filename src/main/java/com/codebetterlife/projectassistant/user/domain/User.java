package com.codebetterlife.projectassistant.user.domain;

import com.codebetterlife.projectassistant.base.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-01 7:25 下午
 */
@Entity
@Getter
@Setter
@Table(name = "t_user")
public class User extends BaseDomain {

    /**
     * 姓名
     */
    @Column(length = 50)
    private String name;

    /**
     * 手机号码
     */
    @Column(length = 11)
    private String mobile;
}
