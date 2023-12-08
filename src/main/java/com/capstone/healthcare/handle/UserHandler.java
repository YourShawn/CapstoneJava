package com.capstone.healthcare.handle;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.UsersQuery;
import com.capstone.healthcare.service.RegistrationService;
import com.capstone.healthcare.service.bo.UsersBO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * Doctors functionalities
 *
 *
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Component
public class UserHandler {

	@Resource
	private RegistrationService registrationService;

    @Transactional(rollbackFor = Exception.class)
    public UsersBO findUserInfo(UsersQuery query){
        List<UsersBO> list = registrationService.findList(query);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    @Transactional(rollbackFor = Exception.class)
    public PageListResult<UsersBO> findPage(UsersQuery query){
        PageListResult<UsersBO> page = registrationService.findPage(query);
        if(ObjectUtils.isEmpty(page) || CollectionUtils.isEmpty(page.getList())){
            return new PageListResult();
        }
        return page;
    }

}
