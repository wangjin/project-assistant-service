package com.codebetterlife.projectassistant.base.domain.criteria;

import com.codebetterlife.projectassistant.base.domain.Operator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-01 6:35 下午
 */
@Getter
@Setter
@NoRepositoryBean
public class BaseCriteria {

    private LongCriteria id;

    private LocalDateTimeCriteria createTime;

    private LocalDateTimeCriteria updateTime;

    private ByteCriteria delFlag;

}
