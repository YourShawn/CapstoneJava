package com.capstone.healthcare.dal.dao;

import com.capstone.healthcare.dal.dataobject.UsersDO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UsersDAO extends Mapper<UsersDO> {
}
