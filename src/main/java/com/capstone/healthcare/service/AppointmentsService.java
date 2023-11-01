package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.service.bo.AppointmentsBO;

import java.util.List;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface AppointmentsService {

    /**
	 * 添加数据
	 * @param
	 * @return
	 */
    int add(AppointmentsBO appointmentsBO);

    /**
     * 修改数据
     * @param
     * @return
     */
    int update(AppointmentsBO appointmentsBO);


    /**
     * query
     * @param query
     * @return
     */
    List<AppointmentsBO> findList(AppointmentsQuery query);
    PageListResult<AppointmentsBO> findPage(AppointmentsQuery query);
}
