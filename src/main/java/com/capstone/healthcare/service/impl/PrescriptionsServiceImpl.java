package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.PrescriptionsDO;
import com.capstone.healthcare.dal.jpa.PrescriptionsJPA;
import com.capstone.healthcare.dal.jpa.PrescriptionsJPA2;
import com.capstone.healthcare.query.PrescriptionsQuery;
import com.capstone.healthcare.service.PrescriptionsService;
import com.capstone.healthcare.service.bo.AppointmentsByPatientNameBO;
import com.capstone.healthcare.service.bo.PrescriptionBODetail;
import com.capstone.healthcare.service.bo.PrescriptionsBO;
import com.capstone.healthcare.service.bo.PrescriptionsByYearBO;
import com.capstone.healthcare.service.convert.PrescriptionsConvert;
import com.google.common.collect.Lists;
import jakarta.annotation.Resource;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Service
public class PrescriptionsServiceImpl implements PrescriptionsService {

    @Resource
    private PrescriptionsJPA prescriptionsJPA;
    @Resource
    private PrescriptionsJPA2 prescriptionsJPA2;


    @Override
    public Integer add(PrescriptionsBO prescriptionsBO) {
        prescriptionsBO.setPrescriptionId(null);
        PrescriptionsDO prescriptionsDO = PrescriptionsConvert.toDO(prescriptionsBO);
        PrescriptionsDO savedPrescription = prescriptionsJPA.save(prescriptionsDO);
        System.out.println("savedPrescription:-->"+savedPrescription.getPrescriptionId());
        return savedPrescription.getPrescriptionId();
    }

    @Override
    public void update(PrescriptionsBO prescriptionsBO) {
        PrescriptionsDO prescriptionsDO = PrescriptionsConvert.toDO(prescriptionsBO);
        prescriptionsJPA.save(prescriptionsDO);
    }

    @Override
    public List<PrescriptionsBO> findList(PrescriptionsQuery query) {
        Iterable<PrescriptionsDO> all = prescriptionsJPA.findAll(this.convertExampleJPA(query));
        return PrescriptionsConvert.toBOList(null);
    }

    @Override
    public PageListResult<PrescriptionsBO> findPage(PrescriptionsQuery pagerCondition) {
        Sort sort = Sort.by(Sort.Direction.DESC,"prescriptionId");
        PageRequest pageRequest = PageRequest.of(pagerCondition.getPageNum(), pagerCondition.getPageSize(),sort);
        Page<PrescriptionsDO> page = prescriptionsJPA.findAll(this.convertExampleJPA(pagerCondition), pageRequest);
        //Setting the set of result
        PageListResult<PrescriptionsBO> pageListResult = new PageListResult(PrescriptionsConvert.toBOList(page.toList()));
        pageListResult.setTotal(page.getTotalElements());
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }

    @Override
    public List<PrescriptionsByYearBO> findGroupYear() {
        List<PrescriptionsByYearBO> list = Lists.newArrayList();
        List<Object[]> objects = prescriptionsJPA2.groupByYear();
        if(CollectionUtils.isEmpty(objects)){
            return list;
        }

        for(Object[] objArry : objects){
            PrescriptionsByYearBO yearBO = new PrescriptionsByYearBO(String.valueOf(objArry[0]),(Long) objArry[1]);
            list.add(yearBO);

        }
        return list;
    }

    @Override
    public String findToday() {
        List<Object[]> objects = prescriptionsJPA2.findToday();
        if(CollectionUtils.isEmpty(objects)){
            return "0";
        }
        return objects.get(0)[0].toString();
    }

    @Override
    public List<PrescriptionBODetail> getPrescriptionDetail(PrescriptionsQuery prescriptionsQuery) {
        ArrayList<PrescriptionBODetail> list = Lists.newArrayList();
        List<Object[]> prescriptionLst = prescriptionsJPA2.getPrescriptionDetail
                (prescriptionsQuery.getPrescriptionId());
        if(CollectionUtils.isEmpty(prescriptionLst)){
            return list;
        }
        for (Object[] objArray : prescriptionLst) {
            PrescriptionBODetail prescriptionBODetail = new PrescriptionBODetail(
                    (Integer) objArray[0],        // prescriptionId
                    (String) objArray[1],         // notes
                    (Date) objArray[2],           // prescriptionDate
                    (Integer) objArray[3],        // medicationId
                    (String) objArray[4],         // medicationName
                    (String) objArray[5],         // description
                    (String) objArray[6],         // dosage
                    (String) objArray[7],         // frequency
                    (Date) objArray[8],           // startDate
                    (Date) objArray[9]            // endDate
            );
            list.add(prescriptionBODetail);
        }

        return list;
    }

    private Example<PrescriptionsDO> convertExampleJPA(PrescriptionsQuery query) {
        PrescriptionsDO probe = new PrescriptionsDO();
        if (!ObjectUtils.isEmpty(query.getPrescriptionId())) {
            probe.setPrescriptionId(query.getPrescriptionId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<PrescriptionsDO> example = Example.of(probe, matcher);
        return example;
    }


}
