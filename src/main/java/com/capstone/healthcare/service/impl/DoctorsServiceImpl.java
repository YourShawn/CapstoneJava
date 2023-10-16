package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dao.DoctorsDAO;
import com.capstone.healthcare.dal.dataobject.DoctorsDO;
import com.capstone.healthcare.query.DoctorsQuery;
import com.capstone.healthcare.service.DoctorsService;
import com.capstone.healthcare.service.bo.DoctorsBO;
import com.capstone.healthcare.service.convert.DoctorsConvert;
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
public class DoctorsServiceImpl implements DoctorsService {

	@Autowired
	private DoctorsDAO doctorsDAO;


    @Override
    public int add(DoctorsBO doctorsBO){
//        doctorsBO.setId(null);
//        doctorsBO.setDelFlag(DelFlagEnum.NOT_DEL.getCode());
//        doctorsBO.setCreateTime(new Date());
//        doctorsBO.setUpdateTime( doctorsBO.getCreateTime());
        DoctorsDO doctorsDO = DoctorsConvert.toDO(doctorsBO);
		return doctorsDAO.insert(doctorsDO);
    }

    @Override
    public int update(DoctorsBO doctorsBO){
		DoctorsDO doctorsDO = DoctorsConvert.toDO(doctorsBO);
        return doctorsDAO.updateByPrimaryKeySelective(doctorsDO);
    }

    @Override
    public List<DoctorsBO> findList(DoctorsQuery query){
        List<DoctorsDO> listByQuery = doctorsDAO.selectByExample(this.convertExample(query));
        return DoctorsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<DoctorsBO> findPage(DoctorsQuery pagerCondition){
        //Setting the parameters of pagination
        pagerCondition.setOrderBy(" ");
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<DoctorsDO> list = doctorsDAO.selectByExample(this.convertExample(pagerCondition));
        //Setting the set of result
        PageListResult<DoctorsBO> pageListResult = new PageListResult(DoctorsConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param doctorsQuery
        * @return
        */
    private Example convertExample(DoctorsQuery doctorsQuery) {
        Example example = new Example(DoctorsDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(doctorsQuery.getDoctorId())) {
            criteria.andEqualTo("doctorId", doctorsQuery.getDoctorId());
        }
        return example;
    }

}
