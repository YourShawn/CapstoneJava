package com.capstone.healthcare.service.impl;


import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dao.AllergiesDAO;
import com.capstone.healthcare.dal.dataobject.AllergiesDO;
import com.capstone.healthcare.query.AllergiesQuery;
import com.capstone.healthcare.service.AllergiesService;
import com.capstone.healthcare.service.bo.AllergiesBO;
import com.capstone.healthcare.service.convert.AllergiesConvert;
import com.github.pagehelper.Page;
import jakarta.annotation.Resource;
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
public class AllergiesServiceImpl implements AllergiesService {

	@Resource
	private AllergiesDAO allergiesDAO;


    @Override
    public int add(AllergiesBO allergiesBO){
        AllergiesDO allergiesDO = AllergiesConvert.toDO(allergiesBO);
		return allergiesDAO.insert(allergiesDO);
    }

    @Override
    public int update(AllergiesBO allergiesBO){
		AllergiesDO allergiesDO = AllergiesConvert.toDO(allergiesBO);
        return allergiesDAO.updateByPrimaryKeySelective(allergiesDO);
    }

    @Override
    public List<AllergiesBO> findList(AllergiesQuery query){
        List<AllergiesDO> listByQuery = allergiesDAO.selectByExample(this.convertExample(query));
        return AllergiesConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<AllergiesBO> findPage(AllergiesQuery pagerCondition){
        //Setting pagination properties
//        pagerCondition.setOrderBy(" ");
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<AllergiesDO> list = allergiesDAO.selectByExample(this.convertExample(pagerCondition));
        //Setting the set of result
        PageListResult<AllergiesBO> pageListResult = new PageListResult(AllergiesConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param allergiesQuery
        * @return
        */
    private Example convertExample(AllergiesQuery allergiesQuery) {
        Example example = new Example(AllergiesDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(allergiesQuery.getAllergyId())) {
            criteria.andEqualTo("allergyId", allergiesQuery.getAllergyId());
        }
        return example;
    }

}
