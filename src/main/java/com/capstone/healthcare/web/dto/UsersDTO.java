package com.capstone.healthcare.web.dto;

import lombok.Data;

import javax.persistence.Id;

@Data
public class UsersDTO {
    private static final long serialVersionUID = 1L;
    /***/
    @Id
    private Integer userId;
    /***/
    private String fullName;
    /***/
    private String emailAddress;
    /***/
    private String password;
    /***/
    private String phoneNumber;
    /***/
    private String role;
}
