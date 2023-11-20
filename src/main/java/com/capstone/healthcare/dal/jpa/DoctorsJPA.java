package com.capstone.healthcare.dal.jpa;

import com.capstone.healthcare.dal.dataobject.DoctorsDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Repository
public interface DoctorsJPA extends JpaRepository<DoctorsDO,Integer>, QueryByExampleExecutor<DoctorsDO> {
}
