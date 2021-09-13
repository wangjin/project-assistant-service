package com.codebetterlife.projectassistant.user.domain;

import com.codebetterlife.projectassistant.base.domain.Operator;
import com.codebetterlife.projectassistant.base.domain.criteria.BaseCriteria;
import com.codebetterlife.projectassistant.base.domain.criteria.EnumCriteria;
import com.codebetterlife.projectassistant.base.domain.criteria.SearchCriteria;
import com.codebetterlife.projectassistant.base.domain.criteria.StringCriteria;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

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

    @Override
    public List<SearchCriteria> getSearchCriteriaList() {

        List<SearchCriteria> searchCriteriaList = super.getSearchCriteriaList();
        if (!isEmpty(name)) {
            if (!isEmpty(name.getEquals())) {
                searchCriteriaList.add(new SearchCriteria("name", Operator.EQUALS, name.getEquals()));
            } else if (!isEmpty(name.getContains())) {
                searchCriteriaList.add(new SearchCriteria("name", Operator.LIKE, name.getContains()));
            }
        }

        if (!isEmpty(mobile)) {
            if (!isEmpty(mobile.getEquals())) {
                searchCriteriaList.add(new SearchCriteria("mobile", Operator.EQUALS, name.getEquals()));
            } else if (!isEmpty(mobile.getContains())) {
                searchCriteriaList.add(new SearchCriteria("mobile", Operator.LIKE, name.getContains()));
            }
        }

        if (!isEmpty(userType) && !isEmpty(userType.getEquals())) {
            searchCriteriaList.add(new SearchCriteria("userType", Operator.EQUALS, UserType.get(userType.getEquals())));
        }
        return searchCriteriaList;
    }
}
