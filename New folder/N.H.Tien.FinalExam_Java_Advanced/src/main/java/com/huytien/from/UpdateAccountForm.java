package com.huytien.from;


import com.huytien.entity.Account.Role;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateAccountForm {

    private Integer id;

    private String username;

    private String firstName;

    private String lastName;

    private Role role;

    private Integer departmentId;
}
