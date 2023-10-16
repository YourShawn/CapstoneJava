package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.NursesQuery;
import com.capstone.healthcare.service.bo.NursesBO;

import java.util.List;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface NursesService {

    /**
	 * 添加数据
	 * @param
	 * @return
	 */
    int add(NursesBO nursesBO);

    /**
     * 修改数据
     * @param
     * @return
     */
    int update(NursesBO nursesBO);


    /**
     * query
     * @param query
     * @return
     */
    List<NursesBO> findList(NursesQuery query);

    PageListResult<NursesBO> findPage(NursesQuery query);
}
