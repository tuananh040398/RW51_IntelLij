package com.tn.repository;

import com.tn.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountrRepository extends JpaRepository<Account, Integer> {

    Account findByUsername(String username);

    @Query("SELECT account FROM Account account WHERE concat(account.username, ' ',account.fullName, ' ', account.role, ' ', account.department.name) LIKE %?1%")
    public List<Account> search(String keyword);
}
