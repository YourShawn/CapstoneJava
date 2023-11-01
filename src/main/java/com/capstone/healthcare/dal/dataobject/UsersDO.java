package com.capstone.healthcare.dal.dataobject;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table (name = "users")
public class UsersDO {

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
