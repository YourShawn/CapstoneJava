package com.capstone.healthcare.dal.jpa;

import com.capstone.healthcare.dal.dataobject.PatientsDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Repository
public interface PatientsJPA extends JpaRepository<PatientsDO,Integer>, QueryByExampleExecutor<PatientsDO> {

    @Query(value = "SELECT * FROM patients p WHERE p.patient_id IN :patientIds",nativeQuery = true)
    List<PatientsDO> findByPatientIds(@Param("patientIds") List<Integer> patientIds);
}
