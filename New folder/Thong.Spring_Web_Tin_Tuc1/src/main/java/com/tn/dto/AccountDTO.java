package com.tn.dto;

import com.tn.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {
    private Integer id;

    private String userName;

    private String fullName;

    private String email;

    private Account.Role role;

    private String password;

    private String departmentId;


}
