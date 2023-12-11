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
	 * @param
	 * @return
	 */
    void add(DoctorsBO doctorsBO);

    /**
     * @param
     * @return
     */
    void update(DoctorsBO doctorsBO);


    /**
     * query
     * @param query
     * @return
     */
    List<DoctorsBO> findList(DoctorsQuery query);

    PageListResult<DoctorsBO> findPage(DoctorsQuery query);

    public List<Object[]> findList();
}
