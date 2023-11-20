package com.capstone.healthcare.dal.jpa;

import com.capstone.healthcare.dal.dataobject.UsersDO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersJPA extends JpaRepository<UsersDO,Integer>, QueryByExampleExecutor<UsersDO> {

    @Modifying
    @Query("UPDATE users u SET" +
            " u.fullName = :#{#user.fullName != null ? #user.fullName : u.fullName}," +
            " u.emailAddress = :#{#user.emailAddress != null ? #user.emailAddress : u.emailAddress}," +
            " u.password = :#{#user.password != null ? #user.password : u.password}," +
            " u.phoneNumber = :#{#user.phoneNumber != null ? #user.phoneNumber : u.phoneNumber}," +
            " u.role = :#{#user.role != null ? #user.role : u.role}" +
            " WHERE u.userId = :#{#user.userId}")
    void updateSelective(@Param("user") UsersDO user);
}
