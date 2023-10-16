package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dao.PatientsDAO;
import com.capstone.healthcare.dal.dataobject.PatientsDO;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.service.PatientsService;
import com.capstone.healthcare.service.bo.PatientsBO;
import com.capstone.healthcare.service.convert.PatientsConvert;
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
public class PatientsServiceImpl implements PatientsService {

	@Autowired
	private PatientsDAO patientsDAO;


    @Override
    public int add(PatientsBO patientsBO){
        PatientsDO patientsDO = PatientsConvert.toDO(patientsBO);
		return patientsDAO.insert(patientsDO);
    }

    @Override
    public int update(PatientsBO patientsBO){
		PatientsDO patientsDO = PatientsConvert.toDO(patientsBO);
        return patientsDAO.updateByPrimaryKeySelective(patientsDO);
    }

    @Override
    public List<PatientsBO> findList(PatientsQuery query){
        List<PatientsDO> listByQuery = patientsDAO.selectByExample(this.convertExample(query));
        return PatientsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<PatientsBO> findPage(PatientsQuery pagerCondition){
        //Setting the parameters of pagination
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<PatientsDO> list = patientsDAO.selectByExample(this.convertExample(pagerCondition));
        //Setting the set of result
        PageListResult<PatientsBO> pageListResult = new PageListResult(PatientsConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param patientsQuery
        * @return
        */
    private Example convertExample(PatientsQuery patientsQuery) {
        Example example = new Example(PatientsDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(patientsQuery.getPatientId())) {
            criteria.andEqualTo("patientId", patientsQuery.getPatientId());
        }
        return example;
    }

}
