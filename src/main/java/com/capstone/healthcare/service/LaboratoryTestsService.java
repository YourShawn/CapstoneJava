package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.LaboratoryTestsQuery;
import com.capstone.healthcare.service.bo.LaboratoryTestsBO;

import java.util.List;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface LaboratoryTestsService {

    /**
	 * 添加数据
	 * @param
	 * @return
	 */
    int add(LaboratoryTestsBO laboratoryTestsBO);

    /**
     * 修改数据
     * @param
     * @return
     */
    int update(LaboratoryTestsBO laboratoryTestsBO);


    /**
     * query
     * @param query
     * @return
     */
    List<LaboratoryTestsBO> findList(LaboratoryTestsQuery query);

    PageListResult<LaboratoryTestsBO> findPage(LaboratoryTestsQuery query);
}
