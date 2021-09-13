package com.codebetterlife.projectassistant.base.domain.criteria;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-13 11:39 上午
 */
@Data
public class FieldCriteria<T> implements Serializable {

    private T equals;
}
