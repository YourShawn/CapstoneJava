package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.bo.AppointmentsByDayBO;

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
	 * @param
	 * @return
	 */
    void add(AppointmentsBO appointmentsBO);

    /**
     * @param
     * @return
     */
    void update(AppointmentsBO appointmentsBO);

    /**
     * query
     * @param query
     * @return
     */
    List<AppointmentsBO> findList(AppointmentsQuery query);
    PageListResult<AppointmentsBO> findPage(AppointmentsQuery query);



    List<AppointmentsByDayBO> findGroupDays();
}
