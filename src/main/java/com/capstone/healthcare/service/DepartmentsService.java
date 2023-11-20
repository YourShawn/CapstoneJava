package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.DepartmentsQuery;
import com.capstone.healthcare.service.bo.DepartmentsBO;

import java.util.List;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface DepartmentsService {

    /**
	 * 添加数据
	 * @param
	 * @return
	 */
    void add(DepartmentsBO departmentsBO);

    /**
     * 修改数据
     * @param
     * @return
     */
    void update(DepartmentsBO departmentsBO);


    /**
     * query
     * @param query
     * @return
     */
    List<DepartmentsBO> findList(DepartmentsQuery query);

    PageListResult<DepartmentsBO> findPage(DepartmentsQuery query);
}
