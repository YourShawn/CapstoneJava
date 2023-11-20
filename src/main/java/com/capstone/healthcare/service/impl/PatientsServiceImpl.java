package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.PatientLabTestsDO;
import com.capstone.healthcare.dal.dataobject.PatientsDO;
import com.capstone.healthcare.dal.jpa.PatientsJPA;
import com.capstone.healthcare.query.PatientLabTestsQuery;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.service.PatientsService;
import com.capstone.healthcare.service.bo.PatientsBO;
import com.capstone.healthcare.service.convert.PatientsConvert;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
        //Setting the parameters of pagination
//        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
//        page.setReasonable(Boolean.FALSE);
//        List<PatientsDO> list = patientsJPA.selectByExample(this.convertExample(pagerCondition));
//        //Setting the set of result
//        PageListResult<PatientsBO> pageListResult = new PageListResult(PatientsConvert.toBOList(list));
//        PageHelperAdaptor.setPageResult(page, pageListResult);
//        pageListResult.setPageNum(pagerCondition.getPageNum());
//        pageListResult.setPageSize(pagerCondition.getPageSize());
//        return pageListResult;
        return null;
    }

    /**
        *
        * @param patientsQuery
        * @return
        */
//    private Example convertExample(PatientsQuery patientsQuery) {
//        Example example = new Example(PatientsDO.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!ObjectUtils.isEmpty(patientsQuery.getPatientId())) {
//            criteria.andEqualTo("patientId", patientsQuery.getPatientId());
//        }
//        return example;
//    }


    private Example<PatientsDO> convertExampleJPA(PatientsQuery query) {
        PatientsDO probe = new PatientsDO();
        if (!ObjectUtils.isEmpty(query.getPatientId())) {
            probe.setPatientId(query.getPatientId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<PatientsDO> example = Example.of(probe, matcher);
        return example;
    }

}
