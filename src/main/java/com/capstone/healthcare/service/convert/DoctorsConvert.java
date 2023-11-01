package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.DoctorsDO;
import com.capstone.healthcare.service.bo.DoctorsBO;
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
public class DoctorsConvert {

	public static DoctorsBO toBO(DoctorsDO doctorsDO) {
		if (doctorsDO == null) {
            return null;
        }

		DoctorsBO doctorsBO = new DoctorsBO();
        BeanUtils.copyProperties(doctorsDO, doctorsBO);
		return doctorsBO;
	}

	public static DoctorsDO toDO(DoctorsBO doctorsBO) {
        if (doctorsBO == null) {
            return null;
        }

		DoctorsDO doctorsDO = new DoctorsDO();
        BeanUtils.copyProperties(doctorsBO, doctorsDO);
		return doctorsDO;
	}

	public static List<DoctorsBO> toBOList(List<DoctorsDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<DoctorsBO> boList = Lists.newArrayList();
		for (DoctorsDO doctorsDO : doList) {
			if (doctorsDO != null) {
				boList.add(toBO(doctorsDO));
			}
		}
		return boList;
	}

	public static List<DoctorsDO> toDOList(List<DoctorsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
		}

		List<DoctorsDO> doList = Lists.newArrayList();
		for (DoctorsBO doctorsBO : boList) {
			if (doctorsBO != null) {
				doList.add(toDO(doctorsBO));
			}
		}
		return doList;
	}

}
