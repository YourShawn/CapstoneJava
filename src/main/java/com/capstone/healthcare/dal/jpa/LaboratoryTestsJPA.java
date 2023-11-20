package com.capstone.healthcare.dal.jpa;

import com.capstone.healthcare.dal.dataobject.LaboratoryTestsDO;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface LaboratoryTestsJPA extends JpaRepository<LaboratoryTestsDO,Integer> {
}
