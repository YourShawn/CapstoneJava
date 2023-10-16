package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dao.PrescriptionsDAO;
import com.capstone.healthcare.dal.dataobject.PrescriptionsDO;
import com.capstone.healthcare.query.PrescriptionsQuery;
import com.capstone.healthcare.service.PrescriptionsService;
import com.capstone.healthcare.service.bo.PrescriptionsBO;
import com.capstone.healthcare.service.convert.PrescriptionsConvert;
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
public class PrescriptionsServiceImpl implements PrescriptionsService {

	@Autowired
	private PrescriptionsDAO prescriptionsDAO;


    @Override
    public int add(PrescriptionsBO prescriptionsBO){
        PrescriptionsDO prescriptionsDO = PrescriptionsConvert.toDO(prescriptionsBO);
		return prescriptionsDAO.insert(prescriptionsDO);
    }

    @Override
    public int update(PrescriptionsBO prescriptionsBO){
		PrescriptionsDO prescriptionsDO = PrescriptionsConvert.toDO(prescriptionsBO);
        return prescriptionsDAO.updateByPrimaryKeySelective(prescriptionsDO);
    }

    @Override
    public List<PrescriptionsBO> findList(PrescriptionsQuery query){
        List<PrescriptionsDO> listByQuery = prescriptionsDAO.selectByExample(this.convertExample(query));
        return PrescriptionsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<PrescriptionsBO> findPage(PrescriptionsQuery pagerCondition){
        //Setting the parameters of pagination
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<PrescriptionsDO> list = prescriptionsDAO.selectByExample(this.convertExample(pagerCondition));
        //Setting the set of result
        PageListResult<PrescriptionsBO> pageListResult = new PageListResult(PrescriptionsConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param prescriptionsQuery
        * @return
        */
    private Example convertExample(PrescriptionsQuery prescriptionsQuery) {
        Example example = new Example(PrescriptionsDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(prescriptionsQuery.getPrescriptionId())) {
            criteria.andEqualTo("prescriptionId", prescriptionsQuery.getPrescriptionId());
        }
        return example;
    }

}
