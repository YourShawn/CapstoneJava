package com.capstone.healthcare.handle;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.service.AppointmentsService;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.bo.PatientsBO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Resource
    private PatientHandler patientHandler;



    public Long count(){
        AppointmentsQuery query = new AppointmentsQuery();
        query.setPageInfo(0,1);
        PageListResult<AppointmentsBO> page = appointmentsService.findPage(query);
        return page.getTotal();
    }



    public PageListResult<AppointmentsBO> findPage(AppointmentsQuery query){
        PageListResult<AppointmentsBO> page = appointmentsService.findPage(query);
        if(ObjectUtils.isEmpty(page) || CollectionUtils.isEmpty(page.getList())){
            return new PageListResult();
        }
        List<Integer> collect = page.getList().stream().map(AppointmentsBO::getPatientId).collect(Collectors.toList());
        List<PatientsBO> patientsBOList = patientHandler.findByIds(collect);
        if(CollectionUtils.isEmpty(patientsBOList)){
            return page;
        }
        Map<Integer, PatientsBO> patientsBOMap = patientsBOList.stream().collect(Collectors.toMap(PatientsBO::getPatientId, obj -> obj));
        for(AppointmentsBO bo : page.getList()){
            PatientsBO patientsBO = patientsBOMap.get(bo.getPatientId());
            if(ObjectUtils.isEmpty(patientsBO)){
                bo.setPatientName(String.valueOf(bo.getPatientId()));
            }else{
                bo.setPatientName(patientsBO.getFirstName()+ " " +patientsBO.getLastName());
            }
        }

        return page;
    }

}
