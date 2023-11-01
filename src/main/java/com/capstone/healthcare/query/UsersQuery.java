package com.capstone.healthcare.query;

import com.capstone.healthcare.common.modules.PageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;

@Data
@EqualsAndHashCode(callSuper = true)
public class UsersQuery extends PageInfo {

    private static final long serialVersionUID = 1L;

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
