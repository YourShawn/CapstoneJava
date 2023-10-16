package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.DoctorsQuery;
import com.capstone.healthcare.service.bo.DoctorsBO;

import java.util.List;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface DoctorsService {

    /**
	 * 添加数据
	 * @param
	 * @return
	 */
    int add(DoctorsBO doctorsBO);

    /**
     * 修改数据
     * @param
     * @return
     */
    int update(DoctorsBO doctorsBO);


    /**
     * query
     * @param query
     * @return
     */
    List<DoctorsBO> findList(DoctorsQuery query);

    PageListResult<DoctorsBO> findPage(DoctorsQuery query);
}
