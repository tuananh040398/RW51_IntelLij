package com.huytien.dto.entitydto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Integer id;

    private String username;

    private String fullName;

    private String role;

    private String departmentName;

}
