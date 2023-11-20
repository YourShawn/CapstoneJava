package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.LaboratoryTestsDO;
import com.capstone.healthcare.dal.jpa.LaboratoryTestsJPA;
import com.capstone.healthcare.query.LaboratoryTestsQuery;
import com.capstone.healthcare.service.LaboratoryTestsService;
import com.capstone.healthcare.service.bo.LaboratoryTestsBO;
import com.capstone.healthcare.service.convert.LaboratoryTestsConvert;
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
public class LaboratoryTestsServiceImpl implements LaboratoryTestsService {

	@Autowired
	private LaboratoryTestsJPA laboratoryTestsJPA;


    @Override
    public void add(LaboratoryTestsBO laboratoryTestsBO){
        laboratoryTestsBO.setTestId(null);
        LaboratoryTestsDO laboratoryTestsDO = LaboratoryTestsConvert.toDO(laboratoryTestsBO);
		laboratoryTestsJPA.save(laboratoryTestsDO);
    }

    @Override
    public void update(LaboratoryTestsBO laboratoryTestsBO){
		LaboratoryTestsDO laboratoryTestsDO = LaboratoryTestsConvert.toDO(laboratoryTestsBO);
        laboratoryTestsJPA.save(laboratoryTestsDO);
    }

    @Override
    public List<LaboratoryTestsBO> findList(LaboratoryTestsQuery query){
        List<LaboratoryTestsDO> listByQuery = laboratoryTestsJPA.findAll(this.convertExampleJPA(query));
        return LaboratoryTestsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<LaboratoryTestsBO> findPage(LaboratoryTestsQuery pagerCondition){
        //Setting the parameters of pagination
//        pagerCondition.setOrderBy(" ");
//        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
//        page.setReasonable(Boolean.FALSE);
//        List<LaboratoryTestsDO> list = laboratoryTestsDAO.selectByExample(this.convertExample(pagerCondition));
//        //Setting the set of result
//        PageListResult<LaboratoryTestsBO> pageListResult = new PageListResult(LaboratoryTestsConvert.toBOList(list));
//        PageHelperAdaptor.setPageResult(page, pageListResult);
//        pageListResult.setPageNum(pagerCondition.getPageNum());
//        pageListResult.setPageSize(pagerCondition.getPageSize());
//        return pageListResult;
        return null;
    }
    /**
        *
        * @param laboratoryTestsQuery
        * @return
        */
//    private Example convertExample(LaboratoryTestsQuery laboratoryTestsQuery) {
//        Example example = new Example(LaboratoryTestsDO.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!ObjectUtils.isEmpty(laboratoryTestsQuery.getTestId())) {
//            criteria.andEqualTo("testId", laboratoryTestsQuery.getTestId());
//        }
//        return example;
//    }



    private Example<LaboratoryTestsDO> convertExampleJPA(LaboratoryTestsQuery query) {
        LaboratoryTestsDO probe = new LaboratoryTestsDO();
        if(!ObjectUtils.isEmpty(query.getTestId())){
            probe.setTestId(query.getTestId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<LaboratoryTestsDO> example = Example.of(probe, matcher);
        return example;
    }


}
