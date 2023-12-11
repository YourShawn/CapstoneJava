package com.capstone.healthcare.handle;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.query.DoctorsQuery;
import com.capstone.healthcare.service.DoctorsService;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.bo.AppointmentsByPatientNameBO;
import com.capstone.healthcare.service.bo.DoctorsBO;
import com.capstone.healthcare.web.dto.DoctorsListDTO;
import com.google.common.collect.Lists;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
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

    public List<DoctorsListDTO> findList() {
        List<Object[]> listByQuery = doctorsService.findList();
        ArrayList<DoctorsListDTO> list = Lists.newArrayList();
        if (CollectionUtils.isEmpty(listByQuery)) {
            return list; // Return an empty list if listByQuery is empty
        }
        for (Object[] objArray : listByQuery) {
            DoctorsListDTO doctorsListDTO = new DoctorsListDTO(
                    (Integer) objArray[0],
                    (String) objArray[1]
            );
            list.add(doctorsListDTO);
        }
        return list;
    }


}
