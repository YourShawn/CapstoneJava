package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.PrescriptionsDO;
import com.capstone.healthcare.dal.jpa.PrescriptionsJPA;
import com.capstone.healthcare.dal.jpa.PrescriptionsJPA2;
import com.capstone.healthcare.query.PrescriptionsQuery;
import com.capstone.healthcare.service.PrescriptionsService;
import com.capstone.healthcare.service.bo.PrescriptionsBO;
import com.capstone.healthcare.service.bo.PrescriptionsByYearBO;
import com.capstone.healthcare.service.convert.PrescriptionsConvert;
import com.google.common.collect.Lists;
import jakarta.annotation.Resource;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

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
    public void add(PrescriptionsBO prescriptionsBO) {
        prescriptionsBO.setPrescriptionId(null);
        PrescriptionsDO prescriptionsDO = PrescriptionsConvert.toDO(prescriptionsBO);
        prescriptionsJPA.save(prescriptionsDO);
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
