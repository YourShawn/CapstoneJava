package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.MedicalRecordsDO;
import com.capstone.healthcare.dal.jpa.MedicalRecordsJPA;
import com.capstone.healthcare.query.MedicalRecordsQuery;
import com.capstone.healthcare.service.MedicalRecordsService;
import com.capstone.healthcare.service.bo.MedicalRecordsBO;
import com.capstone.healthcare.service.convert.MedicalRecordsConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
        //Setting the parameters of pagination
//        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
//        page.setReasonable(Boolean.FALSE);
//        List<MedicalRecordsDO> list = medicalRecordsDAO.selectByExample(this.convertExample(pagerCondition));
//        //Setting the set of result
//        PageListResult<MedicalRecordsBO> pageListResult = new PageListResult(MedicalRecordsConvert.toBOList(list));
//        PageHelperAdaptor.setPageResult(page, pageListResult);
//        pageListResult.setPageNum(pagerCondition.getPageNum());
//        pageListResult.setPageSize(pagerCondition.getPageSize());
//        return pageListResult;
        return null;
    }

    /**
     * @param medicalRecordsQuery
     * @return
     */
//    private Example convertExample(MedicalRecordsQuery medicalRecordsQuery) {
//        Example example = new Example(MedicalRecordsDO.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!ObjectUtils.isEmpty(medicalRecordsQuery.getRecordId())) {
//            criteria.andEqualTo("recordId", medicalRecordsQuery.getRecordId());
//        }
//        return example;
//    }
//    private Example<MedicalRecordsDO> convertExampleJPA(MedicalRecordsQuery query) {
//        MedicalRecordsDO probe = new MedicalRecordsDO();
//        if (!ObjectUtils.isEmpty(query.getRecordId())) {
//            probe.setRecordId(query.getRecordId());
//        }
//
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
//                .withIgnoreCase();
//
//        Example<MedicalRecordsDO> example = Example.of(probe, matcher);
//        return example;
//    }
//


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
