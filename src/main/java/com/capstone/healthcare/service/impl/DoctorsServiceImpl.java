package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.DoctorsDO;
import com.capstone.healthcare.dal.jpa.DoctorsJPA;
import com.capstone.healthcare.query.DoctorsQuery;
import com.capstone.healthcare.service.DoctorsService;
import com.capstone.healthcare.service.bo.DoctorsBO;
import com.capstone.healthcare.service.convert.DoctorsConvert;
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
public class DoctorsServiceImpl implements DoctorsService {

	@Autowired
	private DoctorsJPA doctorsJPA;



    @Override
    public void add(DoctorsBO doctorsBO){
        doctorsBO.setDoctorId(null);
//        doctorsBO.setDelFlag(DelFlagEnum.NOT_DEL.getCode());
//        doctorsBO.setCreateTime(new Date());
//        doctorsBO.setUpdateTime( doctorsBO.getCreateTime());
        DoctorsDO doctorsDO = DoctorsConvert.toDO(doctorsBO);
        doctorsJPA.save(doctorsDO);
    }

    @Override
    public void update(DoctorsBO doctorsBO){
		DoctorsDO doctorsDO = DoctorsConvert.toDO(doctorsBO);
        doctorsJPA.save(doctorsDO);
    }

    @Override
    public List<DoctorsBO> findList(DoctorsQuery query){
        List<DoctorsDO> listByQuery = doctorsJPA.findAll(this.convertExampleJPA(query));
        return DoctorsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<DoctorsBO> findPage(DoctorsQuery pagerCondition){
        //Setting the parameters of pagination
//        pagerCondition.setOrderBy(" ");
//        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
//        page.setReasonable(Boolean.FALSE);
//        List<DoctorsDO> list = doctorsJPA.selectByExample(this.convertExample(pagerCondition));
//        //Setting the set of result
//        PageListResult<DoctorsBO> pageListResult = new PageListResult(DoctorsConvert.toBOList(list));
//        PageHelperAdaptor.setPageResult(page, pageListResult);
//        pageListResult.setPageNum(pagerCondition.getPageNum());
//        pageListResult.setPageSize(pagerCondition.getPageSize());
//        return pageListResult;
        return null;
    }
    /**
        *
        * @param doctorsQuery
        * @return
        */
//    private Example convertExample(DoctorsQuery doctorsQuery) {
//        Example example = new Example(DoctorsDO.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!ObjectUtils.isEmpty(doctorsQuery.getDoctorId())) {
//            criteria.andEqualTo("doctorId", doctorsQuery.getDoctorId());
//        }
//        return example;
//    }
//


    private Example<DoctorsDO> convertExampleJPA(DoctorsQuery query) {
        DoctorsDO probe = new DoctorsDO();
        if(!ObjectUtils.isEmpty(query.getDoctorId())){
            probe.setDoctorId(query.getDoctorId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<DoctorsDO> example = Example.of(probe, matcher);
        return example;
    }


}
