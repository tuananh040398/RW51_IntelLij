package com.huytien.from;

import com.huytien.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountFormFilter {

    private Account.Role role;

    private String departmentName;
}
