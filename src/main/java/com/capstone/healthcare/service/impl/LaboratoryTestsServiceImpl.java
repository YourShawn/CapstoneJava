package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dao.LaboratoryTestsDAO;
import com.capstone.healthcare.dal.dataobject.LaboratoryTestsDO;
import com.capstone.healthcare.query.LaboratoryTestsQuery;
import com.capstone.healthcare.service.LaboratoryTestsService;
import com.capstone.healthcare.service.bo.LaboratoryTestsBO;
import com.capstone.healthcare.service.convert.LaboratoryTestsConvert;
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
public class LaboratoryTestsServiceImpl implements LaboratoryTestsService {

	@Autowired
	private LaboratoryTestsDAO laboratoryTestsDAO;


    @Override
    public int add(LaboratoryTestsBO laboratoryTestsBO){
        LaboratoryTestsDO laboratoryTestsDO = LaboratoryTestsConvert.toDO(laboratoryTestsBO);
		return laboratoryTestsDAO.insert(laboratoryTestsDO);
    }

    @Override
    public int update(LaboratoryTestsBO laboratoryTestsBO){
		LaboratoryTestsDO laboratoryTestsDO = LaboratoryTestsConvert.toDO(laboratoryTestsBO);
        return laboratoryTestsDAO.updateByPrimaryKeySelective(laboratoryTestsDO);
    }

    @Override
    public List<LaboratoryTestsBO> findList(LaboratoryTestsQuery query){
        List<LaboratoryTestsDO> listByQuery = laboratoryTestsDAO.selectByExample(this.convertExample(query));
        return LaboratoryTestsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<LaboratoryTestsBO> findPage(LaboratoryTestsQuery pagerCondition){
        //Setting the parameters of pagination
        pagerCondition.setOrderBy(" ");
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<LaboratoryTestsDO> list = laboratoryTestsDAO.selectByExample(this.convertExample(pagerCondition));
        //Setting the set of result
        PageListResult<LaboratoryTestsBO> pageListResult = new PageListResult(LaboratoryTestsConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param laboratoryTestsQuery
        * @return
        */
    private Example convertExample(LaboratoryTestsQuery laboratoryTestsQuery) {
        Example example = new Example(LaboratoryTestsDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(laboratoryTestsQuery.getTestId())) {
            criteria.andEqualTo("testId", laboratoryTestsQuery.getTestId());
        }
        return example;
    }

}
