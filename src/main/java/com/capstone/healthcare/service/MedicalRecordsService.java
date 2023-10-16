package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.MedicalRecordsQuery;
import com.capstone.healthcare.service.bo.MedicalRecordsBO;

import java.util.List;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface MedicalRecordsService {

    /**
	 * 添加数据
	 * @param
	 * @return
	 */
    int add(MedicalRecordsBO medicalRecordsBO);

    /**
     * 修改数据
     * @param
     * @return
     */
    int update(MedicalRecordsBO medicalRecordsBO);


    /**
     * query
     * @param query
     * @return
     */
    List<MedicalRecordsBO> findList(MedicalRecordsQuery query);

    PageListResult<MedicalRecordsBO> findPage(MedicalRecordsQuery query);
}
