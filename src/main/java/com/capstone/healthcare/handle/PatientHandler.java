package com.capstone.healthcare.handle;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.service.AllergiesService;
import com.capstone.healthcare.service.PatientsService;
import com.capstone.healthcare.service.bo.AllergiesBO;
import com.capstone.healthcare.service.bo.PatientsBO;
import com.google.common.collect.Lists;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
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
public class PatientHandler {

	@Resource
	private PatientsService patientsService;



    public Long count(){
        PatientsQuery query = new PatientsQuery();
        query.setPageInfo(0,1);
        PageListResult<PatientsBO> page = patientsService.findPage(query);
        return page.getTotal();
    }


    public PageListResult<PatientsBO> findPage(PatientsQuery query){
        PageListResult<PatientsBO> page = patientsService.findPage(query);
        if(ObjectUtils.isEmpty(page) || CollectionUtils.isEmpty(page.getList())){
            return new PageListResult();
        }
        return page;
    }

    public List<PatientsBO> findByIds(List<Integer> ids){
        List<PatientsBO> list = patientsService.findList(ids);
        if(ObjectUtils.isEmpty(list) || CollectionUtils.isEmpty(list)){
            return Lists.newArrayList();
        }
        return list;
    }
    public List<PatientsBO> findList(PatientsQuery query){
        List<PatientsBO> list = patientsService.findList(query);
        if(ObjectUtils.isEmpty(list) || CollectionUtils.isEmpty(list)){
            return Lists.newArrayList();
        }
        return list;
    }

}
