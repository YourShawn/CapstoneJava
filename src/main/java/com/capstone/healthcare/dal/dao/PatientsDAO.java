package com.capstone.healthcare.dal.dao;

import com.capstone.healthcare.dal.dataobject.PatientsDO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Repository
public interface PatientsDAO extends Mapper<PatientsDO> {
}
