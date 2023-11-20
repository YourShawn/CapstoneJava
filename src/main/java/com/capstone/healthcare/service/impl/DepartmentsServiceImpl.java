package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.DepartmentsDO;
import com.capstone.healthcare.dal.jpa.DepartmentsJPA;
import com.capstone.healthcare.query.DepartmentsQuery;
import com.capstone.healthcare.service.DepartmentsService;
import com.capstone.healthcare.service.bo.DepartmentsBO;
import com.capstone.healthcare.service.convert.DepartmentsConvert;
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
public class DepartmentsServiceImpl implements DepartmentsService {

	@Autowired
	private DepartmentsJPA departmentsJPA;


    @Override
    public void add(DepartmentsBO departmentsBO){
        departmentsBO.setDepartmentId(null);
//        departmentsBO.setDelFlag(DelFlagEnum.NOT_DEL.getCode());
//        departmentsBO.setCreateTime(new Date());
//        departmentsBO.setUpdateTime( departmentsBO.getCreateTime());
        DepartmentsDO departmentsDO = DepartmentsConvert.toDO(departmentsBO);
        departmentsJPA.save(departmentsDO);
    }

    @Override
    public void update(DepartmentsBO departmentsBO){
		DepartmentsDO departmentsDO = DepartmentsConvert.toDO(departmentsBO);
        departmentsJPA.save(departmentsDO);
    }

    @Override
    public List<DepartmentsBO> findList(DepartmentsQuery query){
        List<DepartmentsDO> listByQuery = departmentsJPA.findAll(this.convertExampleJPA(query));
        return DepartmentsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<DepartmentsBO> findPage(DepartmentsQuery pagerCondition){
        Sort sort = Sort.by(Sort.Direction.DESC,"departmentId");
        PageRequest pageRequest = PageRequest.of(pagerCondition.getPageNum(), pagerCondition.getPageSize(),sort);
        Page<DepartmentsDO> page = departmentsJPA.findAll(this.convertExampleJPA(pagerCondition), pageRequest);
        //Setting the set of result
        PageListResult<DepartmentsBO> pageListResult = new PageListResult(DepartmentsConvert.toBOList(page.toList()));
        pageListResult.setTotal(page.getTotalElements());
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param departmentsQuery
        * @return
        */
//    private Example convertExample(DepartmentsQuery departmentsQuery) {
//        Example example = new Example(DepartmentsDO.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!ObjectUtils.isEmpty(departmentsQuery.getDepartmentId())) {
//            criteria.andEqualTo("departmentId", departmentsQuery.getDepartmentId());
//        }
//        return example;
//    }



    private Example<DepartmentsDO> convertExampleJPA(DepartmentsQuery query) {
        DepartmentsDO probe = new DepartmentsDO();
        if(!ObjectUtils.isEmpty(query.getDepartmentId())){
            probe.setDepartmentId(query.getDepartmentId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<DepartmentsDO> example = Example.of(probe, matcher);
        return example;
    }
}
