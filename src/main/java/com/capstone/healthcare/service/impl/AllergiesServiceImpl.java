package com.capstone.healthcare.service.impl;


import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.AllergiesDO;
import com.capstone.healthcare.dal.jpa.AllergiesJPA;
import com.capstone.healthcare.query.AllergiesQuery;
import com.capstone.healthcare.service.AllergiesService;
import com.capstone.healthcare.service.bo.AllergiesBO;
import com.capstone.healthcare.service.convert.AllergiesConvert;
import jakarta.annotation.Resource;
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
public class AllergiesServiceImpl implements AllergiesService {

//	@Resource
//	private AllergiesDAO allergiesDAO;
    @Resource
    private AllergiesJPA allergiesJPA;


    @Override
    public void add(AllergiesBO allergiesBO){
        AllergiesDO allergiesDO = AllergiesConvert.toDO(allergiesBO);
		 allergiesJPA.save(allergiesDO);
    }

    @Override
    public void update(AllergiesBO allergiesBO){
		AllergiesDO allergiesDO = AllergiesConvert.toDO(allergiesBO);
        allergiesJPA.save(allergiesDO);
    }

    @Override
    public List<AllergiesBO> findList(AllergiesQuery query){
//        List<AllergiesDO> listByQuery = allergiesDAO.selectByExample(this.convertExample(query));
        List<AllergiesDO> all = allergiesJPA.findAll(convertExampleJPA(query));
        return AllergiesConvert.toBOList(all);
    }

    @Override
    public PageListResult<AllergiesBO> findPage(AllergiesQuery pagerCondition){
        //Setting pagination properties
//        pagerCondition.setOrderBy(" ");
//        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
//        page.setReasonable(Boolean.FALSE);
//        List<AllergiesDO> list = allergiesDAO.selectByExample(this.convertExample(pagerCondition));
//        //Setting the set of result
//        PageListResult<AllergiesBO> pageListResult = new PageListResult(AllergiesConvert.toBOList(list));
//        PageHelperAdaptor.setPageResult(page, pageListResult);
//        pageListResult.setPageNum(pagerCondition.getPageNum());
//        pageListResult.setPageSize(pagerCondition.getPageSize());
//        return pageListResult;
        return null;
    }
    /**
        *
        * @param query
        * @return
        */
//    private Example convertExample(AllergiesQuery allergiesQuery) {
//        Example example = new Example(AllergiesDO.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!ObjectUtils.isEmpty(allergiesQuery.getAllergyId())) {
//            criteria.andEqualTo("allergyId", allergiesQuery.getAllergyId());
//        }
//        return example;
//    }

    private Example<AllergiesDO> convertExampleJPA(AllergiesQuery query) {
        AllergiesDO probe = new AllergiesDO();
        if(!ObjectUtils.isEmpty(query.getAllergyId())){
            probe.setAllergyId(query.getAllergyId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<AllergiesDO> example = Example.of(probe, matcher);
        return example;
    }

}
