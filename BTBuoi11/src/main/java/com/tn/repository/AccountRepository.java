package com.tn.repository;

import com.tn.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByFullName(String fullName);

    List<Account> findByAgeGreaterThan(Integer age);

    List<Account> findByFullNameLike(String fullName);

    List<Account> findByFullNameIsNull();
}
