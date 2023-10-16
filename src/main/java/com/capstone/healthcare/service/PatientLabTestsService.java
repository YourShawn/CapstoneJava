package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.PatientLabTestsQuery;
import com.capstone.healthcare.service.bo.PatientLabTestsBO;

import java.util.List;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface PatientLabTestsService {

    /**
	 * 添加数据
	 * @param
	 * @return
	 */
    int add(PatientLabTestsBO patientLabTestsBO);

    /**
     * 修改数据
     * @param
     * @return
     */
    int update(PatientLabTestsBO patientLabTestsBO);


    /**
     * query
     * @param query
     * @return
     */
    List<PatientLabTestsBO> findList(PatientLabTestsQuery query);

    PageListResult<PatientLabTestsBO> findPage(PatientLabTestsQuery query);
}
