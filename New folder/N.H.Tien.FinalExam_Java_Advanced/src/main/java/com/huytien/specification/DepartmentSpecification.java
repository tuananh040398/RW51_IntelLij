package com.huytien.specification;

import com.huytien.entity.Department;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class DepartmentSpecification {

    @SuppressWarnings("deprecation")
    public static Specification<Department> buildWhere(String search){

        Specification<Department> where = null;

        if (!StringUtils.isEmpty(search)){
            search = search.trim();
            while (search.contains("  ")) {
                search = search.replace("  ", " ");
            }

            CustomSpecification2 name = new CustomSpecification2("name", search);
            where = Specification.where(name);
        }
        return where;
    }

}

@SuppressWarnings("serial")
@RequiredArgsConstructor
class CustomSpecification2 implements Specification<Department>{

    @NonNull
    private String field;

    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(
            Root<Department> root,
            CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {

        if (field.equalsIgnoreCase("name")){
            return criteriaBuilder.like(root.get("name"), "%" + value + "%");
        }
        return null;
    }
}
