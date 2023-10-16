package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dao.MedicalRecordsDAO;
import com.capstone.healthcare.dal.dataobject.MedicalRecordsDO;
import com.capstone.healthcare.query.MedicalRecordsQuery;
import com.capstone.healthcare.service.MedicalRecordsService;
import com.capstone.healthcare.service.bo.MedicalRecordsBO;
import com.capstone.healthcare.service.convert.MedicalRecordsConvert;
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
public class MedicalRecordsServiceImpl implements MedicalRecordsService {

	@Autowired
	private MedicalRecordsDAO medicalRecordsDAO;


    @Override
    public int add(MedicalRecordsBO medicalRecordsBO){
        MedicalRecordsDO medicalRecordsDO = MedicalRecordsConvert.toDO(medicalRecordsBO);
		return medicalRecordsDAO.insert(medicalRecordsDO);
    }

    @Override
    public int update(MedicalRecordsBO medicalRecordsBO){
		MedicalRecordsDO medicalRecordsDO = MedicalRecordsConvert.toDO(medicalRecordsBO);
        return medicalRecordsDAO.updateByPrimaryKeySelective(medicalRecordsDO);
    }

    @Override
    public List<MedicalRecordsBO> findList(MedicalRecordsQuery query){
        List<MedicalRecordsDO> listByQuery = medicalRecordsDAO.selectByExample(this.convertExample(query));
        return MedicalRecordsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<MedicalRecordsBO> findPage(MedicalRecordsQuery pagerCondition){
        //Setting the parameters of pagination
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<MedicalRecordsDO> list = medicalRecordsDAO.selectByExample(this.convertExample(pagerCondition));
        //Setting the set of result
        PageListResult<MedicalRecordsBO> pageListResult = new PageListResult(MedicalRecordsConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param medicalRecordsQuery
        * @return
        */
    private Example convertExample(MedicalRecordsQuery medicalRecordsQuery) {
        Example example = new Example(MedicalRecordsDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(medicalRecordsQuery.getRecordId())) {
            criteria.andEqualTo("recordId", medicalRecordsQuery.getRecordId());
        }
        return example;
    }

}
