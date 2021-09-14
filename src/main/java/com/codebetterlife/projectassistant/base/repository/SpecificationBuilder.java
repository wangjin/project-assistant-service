package com.codebetterlife.projectassistant.base.repository;

import com.codebetterlife.projectassistant.base.domain.criteria.BaseCriteria;
import com.codebetterlife.projectassistant.util.SearchCriteriaUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-13 11:02 上午
 */
@AllArgsConstructor
public class SpecificationBuilder<E> implements Specification<E> {

    private transient BaseCriteria baseCriteria;

    @Override
    public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        SearchCriteriaUtil.getSearchList(baseCriteria).forEach(criteria -> {
            switch (criteria.getOperation()) {
                case EQUALS:
                    predicates.add(criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue()));
                    break;
                case LIKE:
                    predicates.add(criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValue().toString() + "%"));
                    break;
                case GREATER_OR_EQUAL_THAN:
                    predicates.add(criteriaBuilder.ge(root.get(criteria.getKey()), (int) criteria.getValue()));
                    break;
                case GT:
                    predicates.add(criteriaBuilder.gt(root.get(criteria.getKey()), (int) criteria.getValue()));
                    break;
                default:
                    break;
            }
        });

        return query.where(predicates.toArray(new Predicate[0])).getRestriction();
    }
}
