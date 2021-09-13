package com.codebetterlife.projectassistant.base.domain.criteria;

import com.codebetterlife.projectassistant.base.domain.Operator;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-13 10:41 上午
 */
@Data
@AllArgsConstructor
public class SearchCriteria implements Serializable {

    /**
     * 属性
     */
    private String key;
    /**
     * 操作
     */
    private Operator operation;
    /**
     * 值
     */
    private transient Object value;
}
