package com.tn.repository;

import com.tn.dto.AccountDTO;
import com.tn.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>  {

}