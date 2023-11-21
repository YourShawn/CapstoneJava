package com.capstone.healthcare.handle;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.service.AppointmentsService;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.bo.PatientsBO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * Doctors functionalities
 *
 *
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Component
public class AppointmentHandler {

	@Resource
	private AppointmentsService appointmentsService;



    public Long count(){
        AppointmentsQuery query = new AppointmentsQuery();
        query.setPageInfo(0,1);
        PageListResult<AppointmentsBO> page = appointmentsService.findPage(query);
        return page.getTotal();
    }

}
