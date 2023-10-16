package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dao.PatientLabTestsDAO;
import com.capstone.healthcare.dal.dataobject.PatientLabTestsDO;
import com.capstone.healthcare.query.PatientLabTestsQuery;
import com.capstone.healthcare.service.PatientLabTestsService;
import com.capstone.healthcare.service.bo.PatientLabTestsBO;
import com.capstone.healthcare.service.convert.PatientLabTestsConvert;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

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
	private PatientLabTestsDAO patientLabTestsDAO;


    @Override
    public int add(PatientLabTestsBO patientLabTestsBO){
        PatientLabTestsDO patientLabTestsDO = PatientLabTestsConvert.toDO(patientLabTestsBO);
		return patientLabTestsDAO.insert(patientLabTestsDO);
    }

    @Override
    public int update(PatientLabTestsBO patientLabTestsBO){
		PatientLabTestsDO patientLabTestsDO = PatientLabTestsConvert.toDO(patientLabTestsBO);
        return patientLabTestsDAO.updateByPrimaryKeySelective(patientLabTestsDO);
    }

    @Override
    public List<PatientLabTestsBO> findList(PatientLabTestsQuery query){
        List<PatientLabTestsDO> listByQuery = patientLabTestsDAO.selectByExample(this.convertExample(query));
        return PatientLabTestsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<PatientLabTestsBO> findPage(PatientLabTestsQuery pagerCondition){
        //Setting the parameters of pagination
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<PatientLabTestsDO> list = patientLabTestsDAO.selectByExample(this.convertExample(pagerCondition));
        //Setting the set of result
        PageListResult<PatientLabTestsBO> pageListResult = new PageListResult(PatientLabTestsConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param patientLabTestsQuery
        * @return
        */
    private Example convertExample(PatientLabTestsQuery patientLabTestsQuery) {
        Example example = new Example(PatientLabTestsDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(patientLabTestsQuery.getPatientId())) {
            criteria.andEqualTo("patientTestId", patientLabTestsQuery.getPatientId());
        }
        return example;
    }

}
