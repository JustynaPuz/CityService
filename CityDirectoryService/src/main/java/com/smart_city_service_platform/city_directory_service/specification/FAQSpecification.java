package com.smart_city_service_platform.city_directory_service.specification;

import com.smart_city_service_platform.city_directory_service.model.FAQ;
import com.smart_city_service_platform.city_directory_service.model.FAQCategory;
import com.smart_city_service_platform.city_directory_service.search.SearchCriteria;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class FAQSpecification implements Specification<FAQ> {

  private final SearchCriteria criteria;

  public FAQSpecification(SearchCriteria criteria) {
    this.criteria = criteria;
  }

  @Override
  public Predicate toPredicate(
      Root<FAQ> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

    Path<?> path = root.get(criteria.getKey());
    String value = criteria.getValue();
    return switch (criteria.getOperation()) {
      case EQUALITY -> {
        if ("category".equals(criteria.getKey())) {
          yield builder.equal(path, FAQCategory.valueOf(value));
        }
        yield builder.equal(root.get(criteria.getKey()), value);
      }
      case NEGATION -> builder.notEqual(root.get(criteria.getKey()), value);
      case GREATER_THAN -> {
        if ("id".equals(criteria.getKey())) {
          yield builder.greaterThan(path.as(Double.class), Double.valueOf(value));
        }
        yield builder.greaterThan(path.as(String.class), value);
      }
      case LESS_THAN -> {
        if ("id".equals(criteria.getKey())) {
          yield builder.lessThan(path.as(Double.class), Double.valueOf(value));
        }
        yield builder.lessThan(path.as(String.class), value);
      }
      case LIKE -> builder.like(root.get(criteria.getKey()), value);
      case STARTS_WITH -> builder.like(root.get(criteria.getKey()), value + "%");
      case ENDS_WITH -> builder.like(root.get(criteria.getKey()), "%" + value);
      case CONTAINS -> builder.like(root.get(criteria.getKey()), "%" + value + "%");
    };
  }
}
