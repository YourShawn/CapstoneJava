package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dao.DoctorsAvailabilityDAO;
import com.capstone.healthcare.dal.dataobject.DoctorsAvailabilityDO;
import com.capstone.healthcare.query.DoctorsAvailabilityQuery;
import com.capstone.healthcare.service.DoctorsAvailabilityService;
import com.capstone.healthcare.service.bo.DoctorsAvailabilityBO;
import com.capstone.healthcare.service.convert.DoctorsAvailabilityConvert;
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
public class DoctorsAvailabilityServiceImpl implements DoctorsAvailabilityService {

	@Autowired
	private DoctorsAvailabilityDAO doctorsAvailabilityDAO;


    @Override
    public int add(DoctorsAvailabilityBO doctorsAvailabilityBO){
//        doctorsAvailabilityBO.setId(null);
//        doctorsAvailabilityBO.setDelFlag(DelFlagEnum.NOT_DEL.getCode());
//        doctorsAvailabilityBO.setCreateTime(new Date());
//        doctorsAvailabilityBO.setUpdateTime( doctorsAvailabilityBO.getCreateTime());
        DoctorsAvailabilityDO doctorsAvailabilityDO = DoctorsAvailabilityConvert.toDO(doctorsAvailabilityBO);
		return doctorsAvailabilityDAO.insert(doctorsAvailabilityDO);
    }

    @Override
    public int update(DoctorsAvailabilityBO doctorsAvailabilityBO){
		DoctorsAvailabilityDO doctorsAvailabilityDO = DoctorsAvailabilityConvert.toDO(doctorsAvailabilityBO);
        return doctorsAvailabilityDAO.updateByPrimaryKeySelective(doctorsAvailabilityDO);
    }

    @Override
    public List<DoctorsAvailabilityBO> findList(DoctorsAvailabilityQuery query){
        List<DoctorsAvailabilityDO> listByQuery = doctorsAvailabilityDAO.selectByExample(this.convertExample(query));
        return DoctorsAvailabilityConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<DoctorsAvailabilityBO> findPage(DoctorsAvailabilityQuery pagerCondition){
        //Setting the parameters of pagination
        pagerCondition.setOrderBy(" ");
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<DoctorsAvailabilityDO> list = doctorsAvailabilityDAO.selectByExample(this.convertExample(pagerCondition));
        //Setting the set of result
        PageListResult<DoctorsAvailabilityBO> pageListResult = new PageListResult(DoctorsAvailabilityConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param doctorsAvailabilityQuery
        * @return
        */
    private Example convertExample(DoctorsAvailabilityQuery doctorsAvailabilityQuery) {
        Example example = new Example(DoctorsAvailabilityDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(doctorsAvailabilityQuery.getAvailabilityId())) {
            criteria.andEqualTo("availabilityId", doctorsAvailabilityQuery.getAvailabilityId());
        }
        return example;
    }

}
