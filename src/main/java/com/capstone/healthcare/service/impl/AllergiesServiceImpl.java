package com.capstone.healthcare.service.impl;


import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.AllergiesDO;
import com.capstone.healthcare.dal.jpa.AllergiesJPA;
import com.capstone.healthcare.query.AllergiesQuery;
import com.capstone.healthcare.service.AllergiesService;
import com.capstone.healthcare.service.bo.AllergiesBO;
import com.capstone.healthcare.service.convert.AllergiesConvert;
import jakarta.annotation.Resource;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

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
        allergiesBO.setAllergyId(null);
        AllergiesDO allergiesDO = AllergiesConvert.toDO(allergiesBO);
		 allergiesJPA.save(allergiesDO);
    }

    @Override
    public void update(AllergiesBO allergiesBO){
		AllergiesDO allergiesDO = AllergiesConvert.toDO(allergiesBO);
        allergiesJPA.save(allergiesDO);
    }

    @Override
    public AllergiesBO findBtId(Integer allergyId) {
        Optional<AllergiesDO> byId = allergiesJPA.findById(allergyId);
        return AllergiesConvert.toBO(byId.get());
    }

    @Override
    public List<AllergiesBO> findList(AllergiesQuery query){
//        List<AllergiesDO> listByQuery = allergiesDAO.selectByExample(this.convertExample(query));
        List<AllergiesDO> all = allergiesJPA.findAll(convertExampleJPA(query));
        return AllergiesConvert.toBOList(all);
    }

    @Override
    public PageListResult<AllergiesBO> findPage(AllergiesQuery pagerCondition){
        Sort sort = Sort.by(Sort.Direction.DESC,"allergyId");
        PageRequest pageRequest = PageRequest.of(pagerCondition.getPageNum(), pagerCondition.getPageSize(),sort);
        Page<AllergiesDO> pageList = allergiesJPA.findAll(this.convertExampleJPA(pagerCondition), pageRequest);
        //Setting the set of result
        PageListResult<AllergiesBO> pageListResult = new PageListResult(AllergiesConvert.toBOList(pageList.toList()));
        pageListResult.setTotal(pageList.getTotalElements());
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
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
