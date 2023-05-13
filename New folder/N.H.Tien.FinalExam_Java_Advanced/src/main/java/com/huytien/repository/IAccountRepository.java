package com.huytien.repository;

import com.huytien.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

    boolean existsAccountByUsername(String username);

    @Modifying
    @Query("DELETE FROM Account WHERE id IN(:Ids)")
    void deleteByIds(@Param("Ids")List<Integer> Ids);

    Account findByUsername(String username);

}
