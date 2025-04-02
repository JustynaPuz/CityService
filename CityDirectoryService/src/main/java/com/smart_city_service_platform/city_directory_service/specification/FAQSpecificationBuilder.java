package com.smart_city_service_platform.city_directory_service.specification;

import com.smart_city_service_platform.city_directory_service.model.FAQ;
import com.smart_city_service_platform.city_directory_service.search.SearchCriteria;
import com.smart_city_service_platform.city_directory_service.search.SearchOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class FAQSpecificationBuilder {

  private final List<SearchCriteria> params = new ArrayList<>();

  public FAQSpecificationBuilder with(String key, SearchOperation op, String value) {
    params.add(new SearchCriteria(key, op, value));
    return this;
  }

  public Specification<FAQ> build() {
    if (params.isEmpty()) {
      return null;
    }
    Specification<FAQ> result = new FAQSpecification(params.getFirst());

    for (int i = 1; i < params.size(); i++) {
      result = result.and(new FAQSpecification(params.get(i)));
    }

    return result;
  }

}
