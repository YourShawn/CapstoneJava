package com.capstone.healthcare.handle;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.service.PatientsService;
import com.capstone.healthcare.service.PrescriptionsService;
import com.capstone.healthcare.service.bo.PatientsBO;
import com.capstone.healthcare.service.bo.PrescriptionsByYearBO;
import com.google.common.collect.Lists;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
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
public class PrescriptionHandler {

	@Resource
	private PrescriptionsService prescriptionsService;



    public List<PrescriptionsByYearBO> findGroupYear(){
        return prescriptionsService.findGroupYear();
    }


}
