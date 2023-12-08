package com.capstone.healthcare.handle;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.query.DoctorsQuery;
import com.capstone.healthcare.service.DoctorsService;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.bo.DoctorsBO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

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
public class DoctorsHandler{

	@Resource
	private DoctorsService doctorsService;


    public void add(DoctorsBO doctorsBO){
        doctorsService.add(doctorsBO);
    }

    public void update(DoctorsBO doctorsBO){
        doctorsService.update(doctorsBO);
    }

    public PageListResult<DoctorsBO> findPage(DoctorsQuery query){
        PageListResult<DoctorsBO> pagerResult = doctorsService.findPage(query);
        return pagerResult;
    }

    public List<DoctorsBO> findList(DoctorsQuery query){
        List<DoctorsBO> list = doctorsService.findList(query);
        return list;
    }
    public Long count(){
        DoctorsQuery query = new DoctorsQuery();
        query.setPageInfo(0,1);
        PageListResult<DoctorsBO> page = doctorsService.findPage(query);
        return page.getTotal();
    }

}
