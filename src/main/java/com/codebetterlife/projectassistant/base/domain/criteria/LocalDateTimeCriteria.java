package com.codebetterlife.projectassistant.base.domain.criteria;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-13 11:40 上午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LocalDateTimeCriteria extends RangeCriteria<LocalDateTime> {

}
