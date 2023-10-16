package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.MedicationsQuery;
import com.capstone.healthcare.service.bo.MedicationsBO;

import java.util.List;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface MedicationsService {

    /**
	 * 添加数据
	 * @param
	 * @return
	 */
    int add(MedicationsBO medicationsBO);

    /**
     * 修改数据
     * @param
     * @return
     */
    int update(MedicationsBO medicationsBO);


    /**
     * query
     * @param query
     * @return
     */
    List<MedicationsBO> findList(MedicationsQuery query);

    PageListResult<MedicationsBO> findPage(MedicationsQuery query);
}
