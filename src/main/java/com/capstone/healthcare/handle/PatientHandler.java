package com.capstone.healthcare.handle;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.service.AllergiesService;
import com.capstone.healthcare.service.PatientsService;
import com.capstone.healthcare.service.bo.AllergiesBO;
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
public class PatientHandler {

	@Resource
	private PatientsService patientsService;



    public Long count(){
        PatientsQuery query = new PatientsQuery();
        query.setPageInfo(0,1);
        PageListResult<PatientsBO> page = patientsService.findPage(query);
        return page.getTotal();
    }

}
