package com.capstone.healthcare.dal.jpa;

import com.capstone.healthcare.dal.dataobject.PrescriptionsDO;
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
public interface PrescriptionsJPA2 extends CrudRepository<PrescriptionsDO,Integer>, QuerydslPredicateExecutor<PrescriptionsDO> {
    @Query(value = "SELECT YEAR(prescription_date) AS year, COUNT(prescription_id) AS count" +
            " FROM prescriptions" +
            " GROUP BY YEAR(prescription_date);", nativeQuery = true)
    List<Object[]> groupByYear();
        public List<PrescriptionsDO> findAllByOrderByPrescriptionId();
}
