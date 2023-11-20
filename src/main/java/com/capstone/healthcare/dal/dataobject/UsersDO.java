package com.capstone.healthcare.dal.dataobject;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Data
@Entity(name = "users")
public class UsersDO {

    private static final long serialVersionUID = 1L;
    /***/
    @Id
    @GeneratedValue
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
