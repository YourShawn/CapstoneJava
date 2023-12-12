package com.capstone.healthcare.dal.jpa;

import com.capstone.healthcare.dal.dataobject.AppointmentsDO;
import com.capstone.healthcare.dal.dataobject.DoctorsDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
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
public interface DoctorsJPA2 extends CrudRepository<DoctorsDO,Integer>, QuerydslPredicateExecutor<DoctorsDO> {

    @Query(value = "select doctor_id, doctor_name from doctors", nativeQuery = true)
    List<Object[]> getDoctorsList();


}
