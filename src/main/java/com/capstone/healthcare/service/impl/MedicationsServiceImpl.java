package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dao.MedicationsDAO;
import com.capstone.healthcare.dal.dataobject.MedicationsDO;
import com.capstone.healthcare.query.MedicationsQuery;
import com.capstone.healthcare.service.MedicationsService;
import com.capstone.healthcare.service.bo.MedicationsBO;
import com.capstone.healthcare.service.convert.MedicationsConvert;
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
public class MedicationsServiceImpl implements MedicationsService {

	@Autowired
	private MedicationsDAO medicationsDAO;


    @Override
    public int add(MedicationsBO medicationsBO){
        MedicationsDO medicationsDO = MedicationsConvert.toDO(medicationsBO);
		return medicationsDAO.insert(medicationsDO);
    }

    @Override
    public int update(MedicationsBO medicationsBO){
		MedicationsDO medicationsDO = MedicationsConvert.toDO(medicationsBO);
        return medicationsDAO.updateByPrimaryKeySelective(medicationsDO);
    }

    @Override
    public List<MedicationsBO> findList(MedicationsQuery query){
        List<MedicationsDO> listByQuery = medicationsDAO.selectByExample(this.convertExample(query));
        return MedicationsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<MedicationsBO> findPage(MedicationsQuery pagerCondition){
        //Setting the parameters of pagination
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<MedicationsDO> list = medicationsDAO.selectByExample(this.convertExample(pagerCondition));
        //Setting the set of result
        PageListResult<MedicationsBO> pageListResult = new PageListResult(MedicationsConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param medicationsQuery
        * @return
        */
    private Example convertExample(MedicationsQuery medicationsQuery) {
        Example example = new Example(MedicationsDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(medicationsQuery.getMedicationId())) {
            criteria.andEqualTo("medicationId", medicationsQuery.getMedicationId());
        }
        return example;
    }

}
