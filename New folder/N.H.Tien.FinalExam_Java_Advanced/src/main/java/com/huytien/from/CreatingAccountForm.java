package com.huytien.from;


import com.huytien.entity.Account.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingAccountForm {

    private String username;

    private String firstName;

    private String lastName;

    private Role role;

    private Integer departmentId;
}
