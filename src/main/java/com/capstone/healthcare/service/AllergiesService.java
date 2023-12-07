package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.AllergiesQuery;
import com.capstone.healthcare.service.bo.AllergiesBO;

import java.util.List;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface AllergiesService {

    /**
	 * @param
	 * @return
	 */
    void add(AllergiesBO allergiesBO);

    /**
     * @param
     * @return
     */
    void update(AllergiesBO allergiesBO);

    AllergiesBO findBtId(Integer allergyId);

    /**
     * query
     * @param query
     * @return
     */
    List<AllergiesBO> findList(AllergiesQuery query);

    PageListResult<AllergiesBO> findPage(AllergiesQuery query);
}
