package com.codebetterlife.projectassistant.user.domain;

import com.codebetterlife.projectassistant.base.domain.criteria.BaseCriteria;
import com.codebetterlife.projectassistant.base.domain.criteria.EnumCriteria;
import com.codebetterlife.projectassistant.base.domain.criteria.StringCriteria;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-01 7:25 下午
 */
@Getter
@Setter
@NoRepositoryBean
public class UserCriteria extends BaseCriteria {

    /**
     * 姓名
     */
    private StringCriteria name;

    /**
     * 手机号码
     */
    private StringCriteria mobile;

    /**
     * 用户类型
     */
    private EnumCriteria userType;
}
