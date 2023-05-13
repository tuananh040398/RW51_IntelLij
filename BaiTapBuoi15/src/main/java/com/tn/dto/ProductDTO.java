package com.tn.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ProductDTO {
    private Integer id;
    private String productName;
    private Integer price;
    private Date createdDate;
}
