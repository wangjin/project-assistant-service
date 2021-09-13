package com.codebetterlife.projectassistant.user.domain;

import com.codebetterlife.projectassistant.base.domain.BaseDomain;
import com.codebetterlife.projectassistant.worktime.domain.WorkTime;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-01 7:25 下午
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    /**
     * 用户类型
     */
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    /**
     * 工时列表
     */
    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<WorkTime> workTimeList;

}
