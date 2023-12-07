package com.capstone.healthcare.handle;

import com.capstone.healthcare.common.Constants;
import com.capstone.healthcare.common.NumberUtil;
import com.capstone.healthcare.common.TokenConstants;
import com.capstone.healthcare.common.TokenKeyUtil;
import com.capstone.healthcare.common.exception.BusinessException;
import com.capstone.healthcare.common.exception.ErrorCode;
import com.capstone.healthcare.service.DoctorsService;
import com.capstone.healthcare.service.bo.AdminUserTokenBO;
import com.capstone.healthcare.service.bo.LoginBO;
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
	private DoctorsService doctorsService;


    /**
     * login with blockchain and public key
     * @param adminUserLoginBO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String adminLogin(LoginBO adminUserLoginBO){
        if(ObjectUtils.isEmpty(adminUserLoginBO)
                || ObjectUtils.isEmpty(adminUserLoginBO.getPassword())
                || ObjectUtils.isEmpty(adminUserLoginBO.getUsername())){
            throw new BusinessException(ErrorCode.PARAM_IS_ERROR);
        }

        if(!adminUserLoginBO.getUsername().equals("admin")
                || !adminUserLoginBO.getPassword().equals("admin888") ){
            throw new BusinessException(ErrorCode.USER_PASSWORD_IS_ERROR);
        }
        AdminUserTokenBO adminUserTokenBO = new AdminUserTokenBO();
        adminUserTokenBO.setId(System.currentTimeMillis());
        adminUserTokenBO.setUserName("TokenAdmin");
        //Save the token and information to Cache
        String token = NumberUtil.getUpperUUID();
        TokenConstants.TOKEN_HASH_MAP.put(TokenKeyUtil.adminLoginToken2Info(token), Constants.GSON.toJson(adminUserTokenBO));
        TokenConstants.TOKEN_HASH_MAP.put(TokenKeyUtil.adminLoginId2Token(adminUserTokenBO.getId()), token);
        return token;
    }



    /**
     * login with blockchain and public key
     * @param adminUserLoginBO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String doctorLogin(LoginBO adminUserLoginBO){
        if(ObjectUtils.isEmpty(adminUserLoginBO)
                || ObjectUtils.isEmpty(adminUserLoginBO.getPassword())
                || ObjectUtils.isEmpty(adminUserLoginBO.getUsername())){
            throw new BusinessException(ErrorCode.PARAM_IS_ERROR);
        }

        if(!adminUserLoginBO.getUsername().equals("doctor")
                || !adminUserLoginBO.getPassword().equals("doctor111") ){
            throw new BusinessException(ErrorCode.USER_PASSWORD_IS_ERROR);
        }
        AdminUserTokenBO adminUserTokenBO = new AdminUserTokenBO();
        adminUserTokenBO.setId(System.currentTimeMillis());
        adminUserTokenBO.setUserName("doctor");
        //Save the token and information to Cache
        String token = NumberUtil.getUpperUUID();
        TokenConstants.TOKEN_HASH_MAP.put(TokenKeyUtil.adminLoginToken2Info(token), Constants.GSON.toJson(adminUserTokenBO));
        TokenConstants.TOKEN_HASH_MAP.put(TokenKeyUtil.adminLoginId2Token(adminUserTokenBO.getId()), token);
        return token;
    }


    /**
     * login with blockchain and public key
     * @param adminUserLoginBO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String patientLogin(LoginBO adminUserLoginBO){
        if(ObjectUtils.isEmpty(adminUserLoginBO)
                || ObjectUtils.isEmpty(adminUserLoginBO.getPassword())
                || ObjectUtils.isEmpty(adminUserLoginBO.getUsername())){
            throw new BusinessException(ErrorCode.PARAM_IS_ERROR);
        }

        if(!adminUserLoginBO.getUsername().equals("patient")
                || !adminUserLoginBO.getPassword().equals("patient111") ){
            throw new BusinessException(ErrorCode.USER_PASSWORD_IS_ERROR);
        }
        AdminUserTokenBO adminUserTokenBO = new AdminUserTokenBO();
        adminUserTokenBO.setId(System.currentTimeMillis());
        adminUserTokenBO.setUserName("patient");
        //Save the token and information to Cache
        String token = NumberUtil.getUpperUUID();
        TokenConstants.TOKEN_HASH_MAP.put(TokenKeyUtil.adminLoginToken2Info(token), Constants.GSON.toJson(adminUserTokenBO));
        TokenConstants.TOKEN_HASH_MAP.put(TokenKeyUtil.adminLoginId2Token(adminUserTokenBO.getId()), token);
        return token;
    }

}
