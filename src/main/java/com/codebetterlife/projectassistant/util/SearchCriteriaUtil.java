package com.codebetterlife.projectassistant.util;

import com.codebetterlife.projectassistant.base.domain.Operator;
import com.codebetterlife.projectassistant.base.domain.criteria.*;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-14 9:21 上午
 */
@Slf4j
public class SearchCriteriaUtil {

    public static List<SearchCriteria> getSearchList(BaseCriteria criteria) {

        List<SearchCriteria> searchCriteriaList = new ArrayList<>();

        Method[] methods = criteria.getClass().getMethods();
        Arrays.stream(methods).filter(method -> method.getName().startsWith("get")).forEach(method -> {
            try {
                // 获取属性名
                String fieldName = method.getName().replace("get", "").toLowerCase(Locale.ROOT);
                // 执行方法获取返回
                Object invoke = method.invoke(criteria);
                if (invoke != null) {
                    if (invoke instanceof LongCriteria) {
                        LongCriteria longCriteria = (LongCriteria) invoke;
                        if (!isEmpty(longCriteria.getEquals())) {
                            searchCriteriaList.add(new SearchCriteria(fieldName, Operator.EQUALS, longCriteria.getEquals()));
                        } else if (!isEmpty(longCriteria.getGreaterOrEqualThan())) {
                            searchCriteriaList.add(new SearchCriteria(fieldName, Operator.GREATER_OR_EQUAL_THAN, longCriteria.getEquals()));
                        } else if (!isEmpty(longCriteria.getLessOrEqualThan())) {
                            searchCriteriaList.add(new SearchCriteria(fieldName, Operator.LESS_OR_EQUAL_THAN, longCriteria.getEquals()));
                        }
                    } else if (invoke instanceof StringCriteria) {
                        StringCriteria stringCriteria = (StringCriteria) invoke;
                        if (!isEmpty(stringCriteria.getEquals())) {
                            searchCriteriaList.add(new SearchCriteria(fieldName, Operator.EQUALS, stringCriteria.getEquals()));
                        } else if (!isEmpty(stringCriteria.getContains())) {
                            searchCriteriaList.add(new SearchCriteria(fieldName, Operator.LIKE, stringCriteria.getContains()));
                        }
                    } else if (invoke instanceof ByteCriteria) {
                        ByteCriteria byteCriteria = (ByteCriteria) invoke;
                        if (!isEmpty(byteCriteria.getEquals())) {
                            searchCriteriaList.add(new SearchCriteria(fieldName, Operator.EQUALS, byteCriteria.getEquals()));
                        } else if (!isEmpty(byteCriteria.getGreaterOrEqualThan())) {
                            searchCriteriaList.add(new SearchCriteria(fieldName, Operator.GREATER_OR_EQUAL_THAN, byteCriteria.getEquals()));
                        } else if (!isEmpty(byteCriteria.getLessOrEqualThan())) {
                            searchCriteriaList.add(new SearchCriteria(fieldName, Operator.LESS_OR_EQUAL_THAN, byteCriteria.getEquals()));
                        }
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error("反射发生异常，当前方法为：{}", method.getName(), e);
            }
        });

        // 默认添加删除标识
        if (searchCriteriaList.stream().noneMatch(o -> "delFlag".equals(o.getKey()))) {
            searchCriteriaList.add(new SearchCriteria("delFlag", Operator.EQUALS, (byte) 0));
        }

        return searchCriteriaList;
    }
}
