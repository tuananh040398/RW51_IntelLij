package com.tn.dto;

import com.tn.entity.Account;
import lombok.Data;

@Data
public class CreatingAccountForm {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private Account.Role role;

    private Integer departmentId;
}
