package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.DoctorsAvailabilityQuery;
import com.capstone.healthcare.service.bo.DoctorsAvailabilityBO;

import java.util.List;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface DoctorsAvailabilityService {

    /**
	 * 添加数据
	 * @param
	 * @return
	 */
    void add(DoctorsAvailabilityBO doctorsAvailabilityBO);

    /**
     * 修改数据
     * @param
     * @return
     */
    void update(DoctorsAvailabilityBO doctorsAvailabilityBO);


    /**
     * query
     * @param query
     * @return
     */
    List<DoctorsAvailabilityBO> findList(DoctorsAvailabilityQuery query);

    PageListResult<DoctorsAvailabilityBO> findPage(DoctorsAvailabilityQuery query);
}
