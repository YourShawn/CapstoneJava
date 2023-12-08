package com.capstone.healthcare.handle;

import com.capstone.healthcare.common.Constants;
import com.capstone.healthcare.common.NumberUtil;
import com.capstone.healthcare.common.TokenConstants;
import com.capstone.healthcare.common.TokenKeyUtil;
import com.capstone.healthcare.common.exception.BusinessException;
import com.capstone.healthcare.common.exception.ErrorCode;
import com.capstone.healthcare.query.UsersQuery;
import com.capstone.healthcare.service.DoctorsService;
import com.capstone.healthcare.service.bo.AdminUserTokenBO;
import com.capstone.healthcare.service.bo.LoginBO;
import com.capstone.healthcare.service.bo.UsersBO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * Doctors functionalities
 *
 *
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Component
public class LoginHandler {

    @Resource
    private UserHandler userHandler;


    /**
     * login with blockchain and public key
     * @param adminUserLoginBO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String userLogin(LoginBO adminUserLoginBO){
        if(ObjectUtils.isEmpty(adminUserLoginBO)
                || ObjectUtils.isEmpty(adminUserLoginBO.getPassword())
                || ObjectUtils.isEmpty(adminUserLoginBO.getUsername())
                || ObjectUtils.isEmpty(adminUserLoginBO.getRole())){
            throw new BusinessException(ErrorCode.PARAM_IS_ERROR);
        }

        UsersQuery query = new UsersQuery();
        query.setEmailAddress(adminUserLoginBO.getUsername());
        query.setRole(adminUserLoginBO.getRole());
        UsersBO userInfo = userHandler.findUserInfo(query);
        if(ObjectUtils.isEmpty(userInfo)){
            throw new BusinessException(ErrorCode.USER_PASSWORD_IS_ERROR);
        }
        if(!userInfo.getPassword().equals(adminUserLoginBO.getPassword()) ){
            throw new BusinessException(ErrorCode.USER_PASSWORD_IS_ERROR);
        }
        AdminUserTokenBO adminUserTokenBO = new AdminUserTokenBO();
        adminUserTokenBO.setId(System.currentTimeMillis());
        adminUserTokenBO.setUserName(userInfo.getFullName());
        //Save the token and information to Cache
        String token = NumberUtil.getUpperUUID();
        TokenConstants.TOKEN_HASH_MAP.put(TokenKeyUtil.adminLoginToken2Info(token), Constants.GSON.toJson(adminUserTokenBO));
        TokenConstants.TOKEN_HASH_MAP.put(TokenKeyUtil.adminLoginId2Token(adminUserTokenBO.getId()), token);
        return token;
    }

    public AdminUserTokenBO getInfo(String token){
        String s = TokenConstants.TOKEN_HASH_MAP.get(token);
        return Constants.GSON.fromJson(s,AdminUserTokenBO.class);
    }

}
