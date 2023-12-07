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
	 * @param
	 * @return
	 */
    void add(NursesBO nursesBO);

    /**
     * @param
     * @return
     */
    void update(NursesBO nursesBO);


    /**
     * query
     * @param query
     * @return
     */
    List<NursesBO> findList(NursesQuery query);

    PageListResult<NursesBO> findPage(NursesQuery query);
}
