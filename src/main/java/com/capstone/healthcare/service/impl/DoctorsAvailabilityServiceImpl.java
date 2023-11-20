package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.DoctorsAvailabilityDO;
import com.capstone.healthcare.dal.jpa.DoctorsAvailabilityJPA;
import com.capstone.healthcare.query.DoctorsAvailabilityQuery;
import com.capstone.healthcare.service.DoctorsAvailabilityService;
import com.capstone.healthcare.service.bo.DoctorsAvailabilityBO;
import com.capstone.healthcare.service.convert.DoctorsAvailabilityConvert;
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
public class DoctorsAvailabilityServiceImpl implements DoctorsAvailabilityService {

	@Autowired
	private DoctorsAvailabilityJPA doctorsAvailabilityJPA;


    @Override
    public void add(DoctorsAvailabilityBO doctorsAvailabilityBO){
        doctorsAvailabilityBO.setAvailabilityId(null);
//        doctorsAvailabilityBO.setDelFlag(DelFlagEnum.NOT_DEL.getCode());
//        doctorsAvailabilityBO.setCreateTime(new Date());
//        doctorsAvailabilityBO.setUpdateTime( doctorsAvailabilityBO.getCreateTime());
        DoctorsAvailabilityDO doctorsAvailabilityDO = DoctorsAvailabilityConvert.toDO(doctorsAvailabilityBO);
        doctorsAvailabilityJPA.save(doctorsAvailabilityDO);
    }

    @Override
    public void update(DoctorsAvailabilityBO doctorsAvailabilityBO){
		DoctorsAvailabilityDO doctorsAvailabilityDO = DoctorsAvailabilityConvert.toDO(doctorsAvailabilityBO);
        doctorsAvailabilityJPA.save(doctorsAvailabilityDO);
    }

    @Override
    public List<DoctorsAvailabilityBO> findList(DoctorsAvailabilityQuery query){
        List<DoctorsAvailabilityDO> listByQuery = doctorsAvailabilityJPA.findAll(this.convertExampleJPA(query));
        return DoctorsAvailabilityConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<DoctorsAvailabilityBO> findPage(DoctorsAvailabilityQuery pagerCondition){
        Sort sort = Sort.by(Sort.Direction.DESC,"availabilityId");
        PageRequest pageRequest = PageRequest.of(pagerCondition.getPageNum(), pagerCondition.getPageSize(),sort);
        Page<DoctorsAvailabilityDO> page = doctorsAvailabilityJPA.findAll(this.convertExampleJPA(pagerCondition), pageRequest);
        //Setting the set of result
        PageListResult<DoctorsAvailabilityBO> pageListResult = new PageListResult(DoctorsAvailabilityConvert.toBOList(page.toList()));
        pageListResult.setTotal(page.getTotalElements());
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }


    private Example<DoctorsAvailabilityDO> convertExampleJPA(DoctorsAvailabilityQuery query) {
        DoctorsAvailabilityDO probe = new DoctorsAvailabilityDO();
        if(!ObjectUtils.isEmpty(query.getAvailabilityId())){
            probe.setAvailabilityId(query.getAvailabilityId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<DoctorsAvailabilityDO> example = Example.of(probe, matcher);
        return example;
    }

}
