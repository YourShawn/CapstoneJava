package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.PrescriptionsQuery;
import com.capstone.healthcare.service.bo.PrescriptionsBO;

import java.util.List;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface PrescriptionsService {

    /**
	 * 添加数据
	 * @param
	 * @return
	 */
    void add(PrescriptionsBO prescriptionsBO);

    /**
     * 修改数据
     * @param
     * @return
     */
    void update(PrescriptionsBO prescriptionsBO);


    /**
     * query
     * @param query
     * @return
     */
    List<PrescriptionsBO> findList(PrescriptionsQuery query);

    PageListResult<PrescriptionsBO> findPage(PrescriptionsQuery query);
}
