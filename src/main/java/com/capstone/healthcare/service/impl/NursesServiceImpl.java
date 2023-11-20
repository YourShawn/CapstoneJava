package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.NursesDO;
import com.capstone.healthcare.dal.jpa.NursesJPA;
import com.capstone.healthcare.query.NursesQuery;
import com.capstone.healthcare.service.NursesService;
import com.capstone.healthcare.service.bo.NursesBO;
import com.capstone.healthcare.service.convert.NursesConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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
public class NursesServiceImpl implements NursesService {

	@Autowired
	private NursesJPA nursesJPA;


    @Override
    public void add(NursesBO nursesBO){
        nursesBO.setNurseId(null);
        NursesDO nursesDO = NursesConvert.toDO(nursesBO);
		nursesJPA.save(nursesDO);
    }

    @Override
    public void update(NursesBO nursesBO){
		NursesDO nursesDO = NursesConvert.toDO(nursesBO);
        nursesJPA.save(nursesDO);
    }

    @Override
    public List<NursesBO> findList(NursesQuery query){
        List<NursesDO> listByQuery = nursesJPA.findAll(this.convertExampleJPA(query));
        return NursesConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<NursesBO> findPage(NursesQuery pagerCondition){
        Sort sort = Sort.by(Sort.Direction.DESC,"nurseId");
        PageRequest pageRequest = PageRequest.of(pagerCondition.getPageNum(), pagerCondition.getPageSize(),sort);
        Page<NursesDO> page = nursesJPA.findAll(this.convertExampleJPA(pagerCondition), pageRequest);
        //Setting the set of result
        PageListResult<NursesBO> pageListResult = new PageListResult(NursesConvert.toBOList(page.toList()));
        pageListResult.setTotal(page.getTotalElements());
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param nursesQuery
        * @return
        */
//    private Example convertExample(NursesQuery nursesQuery) {
//        Example example = new Example(NursesDO.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!ObjectUtils.isEmpty(nursesQuery.getNurseId())) {
//            criteria.andEqualTo("nurseId", nursesQuery.getNurseId());
//        }
//        return example;
//    }


    private Example<NursesDO> convertExampleJPA(NursesQuery query) {
        NursesDO probe = new NursesDO();
        if (!ObjectUtils.isEmpty(query.getNurseId())) {
            probe.setNurseId(query.getNurseId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<NursesDO> example = Example.of(probe, matcher);
        return example;
    }

}
