package com.huytien.specification;

import com.huytien.entity.Account;
import com.huytien.from.AccountFormFilter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccountSpecification {

    @SuppressWarnings("deprecation")
    public static Specification<Account> buildWhere(String search, AccountFormFilter accountFormFilter) {

        Specification<Account> where = null;

        if (!StringUtils.isEmpty(search)) {
            search = search.trim();
            while (search.contains("  ")) {
                search = search.replace("  ", " ");
            }

            CustomSpecification username = new CustomSpecification("username", search);
            CustomSpecification fullName = new CustomSpecification("fullName", search);

            where = Specification.where(username).or(fullName);
        }

        if (accountFormFilter != null && accountFormFilter.getRole() != null){
            CustomSpecification role = new CustomSpecification("role", accountFormFilter.getRole());
            if (where == null){
                where = role;
            } else {
                where = where.and(role);
            }
        }

        if (accountFormFilter != null && accountFormFilter.getDepartmentName() != null){
            CustomSpecification departmentName = new CustomSpecification("departmentName", accountFormFilter.getDepartmentName());
            if (where == null){
                where = departmentName;
            } else {
                where = where.and(departmentName);
            }
        }

        return where;

    }
}


@SuppressWarnings("serial")
@RequiredArgsConstructor
class CustomSpecification implements Specification<Account>{

    @NonNull
    private String field;

    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(
            Root<Account> root,
            CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {

        if (field.equalsIgnoreCase("username")){
            return criteriaBuilder.like(root.get("username"), "%" + value.toString() + "%");
        }

        if (field.equalsIgnoreCase("fullName")){
            return criteriaBuilder.like(root.get("fullName"), "%" + value.toString() + "%");
        }

        if (field.equalsIgnoreCase("role")){
            return criteriaBuilder.equal(root.get("role"), value);
        }

        if (field.equalsIgnoreCase("departmentName")){
            return criteriaBuilder.equal(root.get("department").get("name"), value.toString());
        }
        return null;
    }
}

