package com.codebetterlife.projectassistant.base.domain.criteria;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-13 11:38 上午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RangeCriteria<T extends Comparable<? super T>> extends FieldCriteria<T> {

    private T greaterOrEqualThan;

    private T lessOrEqualThan;
}
