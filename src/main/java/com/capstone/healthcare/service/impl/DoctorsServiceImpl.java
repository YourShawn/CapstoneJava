package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.DoctorsDO;
import com.capstone.healthcare.dal.jpa.DoctorsJPA;
import com.capstone.healthcare.dal.jpa.DoctorsJPA2;
import com.capstone.healthcare.query.DoctorsQuery;
import com.capstone.healthcare.service.DoctorsService;
import com.capstone.healthcare.service.bo.DoctorsBO;
import com.capstone.healthcare.service.convert.DoctorsConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 *
 *
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Service
public class DoctorsServiceImpl implements DoctorsService {

	@Autowired
	private DoctorsJPA doctorsJPA;

    @Autowired
    private DoctorsJPA2 doctorsJPA2;



    @Override
    public void add(DoctorsBO doctorsBO){
        doctorsBO.setDoctorId(null);
        DoctorsDO doctorsDO = DoctorsConvert.toDO(doctorsBO);
        doctorsJPA.save(doctorsDO);
    }


    @Override
    public void update(DoctorsBO doctorsBO){
		DoctorsDO doctorsDO = DoctorsConvert.toDO(doctorsBO);
        doctorsJPA.save(doctorsDO);
    }

    @Override
    public List<DoctorsBO> findList(DoctorsQuery query){
        List<DoctorsDO> listByQuery = doctorsJPA.findAll(this.convertExampleJPA(query));
        return DoctorsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<DoctorsBO> findPage(DoctorsQuery pagerCondition){
        Sort sort = Sort.by(Sort.Direction.DESC,"doctorId");
        PageRequest pageRequest = PageRequest.of(pagerCondition.getPageNum(), pagerCondition.getPageSize(),sort);
        Page<DoctorsDO> page = doctorsJPA.findAll(this.convertExampleJPA(pagerCondition), pageRequest);
        //Setting the set of result
        PageListResult<DoctorsBO> pageListResult = new PageListResult(DoctorsConvert.toBOList(page.toList()));
        pageListResult.setTotal(page.getTotalElements());
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }


    private Example<DoctorsDO> convertExampleJPA(DoctorsQuery query) {
        DoctorsDO probe = new DoctorsDO();
        if(!ObjectUtils.isEmpty(query.getDoctorId())){
            probe.setDoctorId(query.getDoctorId());
        }
        if(!ObjectUtils.isEmpty(query.getUserId())){
            probe.setUserId(query.getUserId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<DoctorsDO> example = Example.of(probe, matcher);
        return example;
    }

    @Override
    public List<Object[]> findList(){
        List<Object[]> listByQuery = doctorsJPA2.getDoctorsList();
        return listByQuery;
    }

}
