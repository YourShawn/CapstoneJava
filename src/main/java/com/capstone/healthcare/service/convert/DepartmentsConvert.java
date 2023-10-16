package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.DepartmentsDO;
import com.capstone.healthcare.service.bo.DepartmentsBO;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * 
 *
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public class DepartmentsConvert {

	public static DepartmentsBO toBO(DepartmentsDO departmentsDO) {
		if (departmentsDO == null) {
            return null;
        }

		DepartmentsBO departmentsBO = new DepartmentsBO();
        BeanUtils.copyProperties(departmentsBO, departmentsDO);
		return departmentsBO;
	}

	public static DepartmentsDO toDO(DepartmentsBO departmentsBO) {
        if (departmentsBO == null) {
            return null;
        }

		DepartmentsDO departmentsDO = new DepartmentsDO();
        BeanUtils.copyProperties(departmentsDO, departmentsBO);
		return departmentsDO;
	}

	public static List<DepartmentsBO> toBOList(List<DepartmentsDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<DepartmentsBO> boList = Lists.newArrayList();
		for (DepartmentsDO departmentsDO : doList) {
			if (departmentsDO != null) {
				boList.add(toBO(departmentsDO));
			}
		}
		return boList;
	}

	public static List<DepartmentsDO> toDOList(List<DepartmentsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
		}

		List<DepartmentsDO> doList = Lists.newArrayList();
		for (DepartmentsBO departmentsBO : boList) {
			if (departmentsBO != null) {
				doList.add(toDO(departmentsBO));
			}
		}
		return doList;
	}

}
