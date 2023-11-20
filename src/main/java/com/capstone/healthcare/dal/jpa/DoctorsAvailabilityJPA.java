package com.capstone.healthcare.dal.jpa;

import com.capstone.healthcare.dal.dataobject.DoctorsAvailabilityDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface DoctorsAvailabilityJPA extends JpaRepository<DoctorsAvailabilityDO,Integer>, QueryByExampleExecutor<DoctorsAvailabilityDO> {
}
