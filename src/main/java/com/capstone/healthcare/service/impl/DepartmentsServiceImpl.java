package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dao.DepartmentsDAO;
import com.capstone.healthcare.dal.dataobject.DepartmentsDO;
import com.capstone.healthcare.query.DepartmentsQuery;
import com.capstone.healthcare.service.DepartmentsService;
import com.capstone.healthcare.service.bo.DepartmentsBO;
import com.capstone.healthcare.service.convert.DepartmentsConvert;
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
public class DepartmentsServiceImpl implements DepartmentsService {

	@Autowired
	private DepartmentsDAO departmentsDAO;


    @Override
    public int add(DepartmentsBO departmentsBO){
//        departmentsBO.setId(null);
//        departmentsBO.setDelFlag(DelFlagEnum.NOT_DEL.getCode());
//        departmentsBO.setCreateTime(new Date());
//        departmentsBO.setUpdateTime( departmentsBO.getCreateTime());
        DepartmentsDO departmentsDO = DepartmentsConvert.toDO(departmentsBO);
		return departmentsDAO.insert(departmentsDO);
    }

    @Override
    public int update(DepartmentsBO departmentsBO){
		DepartmentsDO departmentsDO = DepartmentsConvert.toDO(departmentsBO);
        return departmentsDAO.updateByPrimaryKeySelective(departmentsDO);
    }

    @Override
    public List<DepartmentsBO> findList(DepartmentsQuery query){
        List<DepartmentsDO> listByQuery = departmentsDAO.selectByExample(this.convertExample(query));
        return DepartmentsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<DepartmentsBO> findPage(DepartmentsQuery pagerCondition){
        //Setting the parameters of pagination
        pagerCondition.setOrderBy(" ");
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<DepartmentsDO> list = departmentsDAO.selectByExample(this.convertExample(pagerCondition));
        //Setting the set of result
        PageListResult<DepartmentsBO> pageListResult = new PageListResult(DepartmentsConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param departmentsQuery
        * @return
        */
    private Example convertExample(DepartmentsQuery departmentsQuery) {
        Example example = new Example(DepartmentsDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(departmentsQuery.getDepartmentId())) {
            criteria.andEqualTo("departmentId", departmentsQuery.getDepartmentId());
        }
        return example;
    }

}
