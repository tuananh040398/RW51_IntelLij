package com.tn.dto;

import lombok.Data;

@Data
public class AccountDTO {

    private Integer id;

    private String username;

    private String fullName;

    private String role;

    private String departmentName;
}
