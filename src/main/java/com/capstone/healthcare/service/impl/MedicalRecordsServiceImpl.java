package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.MedicalRecordsDO;
import com.capstone.healthcare.dal.jpa.MedicalRecordsJPA;
import com.capstone.healthcare.query.MedicalRecordsQuery;
import com.capstone.healthcare.service.MedicalRecordsService;
import com.capstone.healthcare.service.bo.MedicalRecordsBO;
import com.capstone.healthcare.service.convert.MedicalRecordsConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Service
public class MedicalRecordsServiceImpl implements MedicalRecordsService {

    @Autowired
    private MedicalRecordsJPA medicalRecordsJPA;


    @Override
    public void add(MedicalRecordsBO medicalRecordsBO) {
        MedicalRecordsDO medicalRecordsDO = MedicalRecordsConvert.toDO(medicalRecordsBO);
        medicalRecordsJPA.save(medicalRecordsDO);
    }

    @Override
    public void update(MedicalRecordsBO medicalRecordsBO) {
        MedicalRecordsDO medicalRecordsDO = MedicalRecordsConvert.toDO(medicalRecordsBO);
        medicalRecordsJPA.save(medicalRecordsDO);
    }

    @Override
    public List<MedicalRecordsBO> findList(MedicalRecordsQuery query) {
        List<MedicalRecordsDO> listByQuery = medicalRecordsJPA.findAll(this.convertExampleJPA(query));
        return MedicalRecordsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<MedicalRecordsBO> findPage(MedicalRecordsQuery pagerCondition) {
        Sort sort = Sort.by(Sort.Direction.DESC,"recordId");
        PageRequest pageRequest = PageRequest.of(pagerCondition.getPageNum(), pagerCondition.getPageSize(),sort);
        Page<MedicalRecordsDO> page = medicalRecordsJPA.findAll(this.convertExampleJPA(pagerCondition), pageRequest);
        //Setting the set of result
        PageListResult<MedicalRecordsBO> pageListResult = new PageListResult(MedicalRecordsConvert.toBOList(page.toList()));
        pageListResult.setTotal(page.getTotalElements());
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }

    private Example<MedicalRecordsDO> convertExampleJPA(MedicalRecordsQuery query) {
        MedicalRecordsDO probe = new MedicalRecordsDO();
        if(!ObjectUtils.isEmpty(query.getRecordId())){
            probe.setRecordId(query.getRecordId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<MedicalRecordsDO> example = Example.of(probe, matcher);
        return example;
    }



}
