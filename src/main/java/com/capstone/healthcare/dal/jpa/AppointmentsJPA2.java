package com.capstone.healthcare.dal.jpa;

import com.capstone.healthcare.dal.dataobject.AppointmentsDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
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
public interface AppointmentsJPA2 extends CrudRepository<AppointmentsDO,Integer>, QuerydslPredicateExecutor<AppointmentsDO> {

    @Query(value = " select FORMAT(appointment_date_time,'yyyy-MM-dd') as day, count(*) " +
            " from appointments " +
            " group by day " +
            " order by day;", nativeQuery = true)
    List<Object[]> groupByDays();
}
