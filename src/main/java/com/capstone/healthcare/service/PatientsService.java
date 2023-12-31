package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.service.bo.PatientsBO;

import java.util.List;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface PatientsService {

    /**
	 * @param
	 * @return
	 */
    void add(PatientsBO patientsBO);

    /**
     * @param
     * @return
     */
    void update(PatientsBO patientsBO);


    /**
     * query
     * @param query
     * @return
     */
    List<PatientsBO> findList(PatientsQuery query);

    PageListResult<PatientsBO> findPage(PatientsQuery query);

    /**
     * query
     * @param query
     * @return
     */
    List<PatientsBO> findList(List<Integer> query);

}
