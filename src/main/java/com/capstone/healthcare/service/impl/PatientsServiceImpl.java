package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.PatientLabTestsDO;
import com.capstone.healthcare.dal.dataobject.PatientsDO;
import com.capstone.healthcare.dal.jpa.PatientsJPA;
import com.capstone.healthcare.query.PatientLabTestsQuery;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.service.PatientsService;
import com.capstone.healthcare.service.bo.PatientLabTestsBO;
import com.capstone.healthcare.service.bo.PatientsBO;
import com.capstone.healthcare.service.convert.PatientLabTestsConvert;
import com.capstone.healthcare.service.convert.PatientsConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
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
public class PatientsServiceImpl implements PatientsService {

	@Autowired
	private PatientsJPA patientsJPA;


    @Override
    public void add(PatientsBO patientsBO){
        PatientsDO patientsDO = PatientsConvert.toDO(patientsBO);
		patientsJPA.save(patientsDO);
    }

    @Override
    public void update(PatientsBO patientsBO){
		PatientsDO patientsDO = PatientsConvert.toDO(patientsBO);
        patientsJPA.save(patientsDO);
    }

    @Override
    public List<PatientsBO> findList(PatientsQuery query){
        List<PatientsDO> listByQuery = patientsJPA.findAll(this.convertExampleJPA(query));
        return PatientsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<PatientsBO> findPage(PatientsQuery pagerCondition){
        Sort sort = Sort.by(Sort.Direction.DESC,"patientId");
        PageRequest pageRequest = PageRequest.of(pagerCondition.getPageNum(), pagerCondition.getPageSize(),sort);
        Page<PatientsDO> page = patientsJPA.findAll(this.convertExampleJPA(pagerCondition), pageRequest);
        //Setting the set of result
        PageListResult<PatientsBO> pageListResult = new PageListResult(PatientsConvert.toBOList(page.toList()));
        pageListResult.setTotal(page.getTotalElements());
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }

    @Override
    public List<PatientsBO> findList(List<Integer> query) {
        List<PatientsDO> byPatientIds = patientsJPA.findByPatientIds(query);
        return PatientsConvert.toBOList(byPatientIds);
    }



    private Example<PatientsDO> convertExampleJPA(PatientsQuery query) {
        PatientsDO probe = new PatientsDO();
        if (!ObjectUtils.isEmpty(query.getPatientId())) {
            probe.setPatientId(query.getPatientId());
        }
        if (!ObjectUtils.isEmpty(query.getAssignedDoctor())) {
            probe.setAssignedDoctor(Integer.parseInt(query.getAssignedDoctor()));
        }
        if (!ObjectUtils.isEmpty(query.getFirstName())) {
            probe.setFirstName(query.getFirstName());
        }
        if (!ObjectUtils.isEmpty(query.getLastName())) {
            probe.setLastName(query.getLastName());
        }
        if (!ObjectUtils.isEmpty(query.getDateOfBirth())) {
            probe.setDateOfBirth(query.getDateOfBirth());
        }
        if (!ObjectUtils.isEmpty(query.getHealthCardId())) {
            probe.setHealthCardId(query.getHealthCardId());
        }

        if (!ObjectUtils.isEmpty(query.getUserId())) {
            probe.setUserId(query.getUserId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<PatientsDO> example = Example.of(probe, matcher);
        return example;
    }

}
