package com.capstone.healthcare.dal.jpa;

import com.capstone.healthcare.dal.dataobject.UsersDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersJPA extends JpaRepository<UsersDO,Integer>, QueryByExampleExecutor<UsersDO> {
}
