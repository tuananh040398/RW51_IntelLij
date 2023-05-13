package com.tn.account;


import com.tn.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@NoArgsConstructor
public class CreatingAccountForm {

	private String userName;

	private String email;

	private String fullName;

	private Account.Role role;

	private String password;

	private Integer departmentId;

}
