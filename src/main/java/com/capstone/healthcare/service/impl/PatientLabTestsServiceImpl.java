package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.PatientLabTestsDO;
import com.capstone.healthcare.dal.jpa.PatientLabTestsJPA;
import com.capstone.healthcare.query.PatientLabTestsQuery;
import com.capstone.healthcare.service.PatientLabTestsService;
import com.capstone.healthcare.service.bo.PatientLabTestsBO;
import com.capstone.healthcare.service.convert.PatientLabTestsConvert;
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
public class PatientLabTestsServiceImpl implements PatientLabTestsService {

	@Autowired
	private PatientLabTestsJPA patientLabTestsJPA;


    @Override
    public void add(PatientLabTestsBO patientLabTestsBO){
        PatientLabTestsDO patientLabTestsDO = PatientLabTestsConvert.toDO(patientLabTestsBO);
		patientLabTestsJPA.save(patientLabTestsDO);
    }

    @Override
    public void update(PatientLabTestsBO patientLabTestsBO){
		PatientLabTestsDO patientLabTestsDO = PatientLabTestsConvert.toDO(patientLabTestsBO);
        patientLabTestsJPA.save(patientLabTestsDO);
    }

    @Override
    public List<PatientLabTestsBO> findList(PatientLabTestsQuery query){
        List<PatientLabTestsDO> listByQuery = patientLabTestsJPA.findAll(this.convertExampleJPA(query));
        return PatientLabTestsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<PatientLabTestsBO> findPage(PatientLabTestsQuery pagerCondition){
        Sort sort = Sort.by(Sort.Direction.DESC,"patientTestId");
        PageRequest pageRequest = PageRequest.of(pagerCondition.getPageNum(), pagerCondition.getPageSize(),sort);
        Page<PatientLabTestsDO> page = patientLabTestsJPA.findAll(this.convertExampleJPA(pagerCondition), pageRequest);
        //Setting the set of result
        PageListResult<PatientLabTestsBO> pageListResult = new PageListResult(PatientLabTestsConvert.toBOList(page.toList()));
        pageListResult.setTotal(page.getTotalElements());
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param patientLabTestsQuery
        * @return
        */
//    private Example convertExample(PatientLabTestsQuery patientLabTestsQuery) {
//        Example example = new Example(PatientLabTestsDO.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!ObjectUtils.isEmpty(patientLabTestsQuery.getPatientId())) {
//            criteria.andEqualTo("patientTestId", patientLabTestsQuery.getPatientId());
//        }
//        return example;
//    }



    private Example<PatientLabTestsDO> convertExampleJPA(PatientLabTestsQuery query) {
        PatientLabTestsDO probe = new PatientLabTestsDO();
        if (!ObjectUtils.isEmpty(query.getPatientId())) {
            probe.setPatientId(query.getPatientId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<PatientLabTestsDO> example = Example.of(probe, matcher);
        return example;
    }


}
