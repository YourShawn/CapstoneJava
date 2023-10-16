package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.DoctorsAvailabilityDO;
import com.capstone.healthcare.service.bo.DoctorsAvailabilityBO;
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
public class DoctorsAvailabilityConvert {

	public static DoctorsAvailabilityBO toBO(DoctorsAvailabilityDO doctorsAvailabilityDO) {
		if (doctorsAvailabilityDO == null) {
            return null;
        }

		DoctorsAvailabilityBO doctorsAvailabilityBO = new DoctorsAvailabilityBO();
        BeanUtils.copyProperties(doctorsAvailabilityBO, doctorsAvailabilityDO);
		return doctorsAvailabilityBO;
	}

	public static DoctorsAvailabilityDO toDO(DoctorsAvailabilityBO doctorsAvailabilityBO) {
        if (doctorsAvailabilityBO == null) {
            return null;
        }

		DoctorsAvailabilityDO doctorsAvailabilityDO = new DoctorsAvailabilityDO();
        BeanUtils.copyProperties(doctorsAvailabilityDO, doctorsAvailabilityBO);
		return doctorsAvailabilityDO;
	}

	public static List<DoctorsAvailabilityBO> toBOList(List<DoctorsAvailabilityDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<DoctorsAvailabilityBO> boList = Lists.newArrayList();
		for (DoctorsAvailabilityDO doctorsAvailabilityDO : doList) {
			if (doctorsAvailabilityDO != null) {
				boList.add(toBO(doctorsAvailabilityDO));
			}
		}
		return boList;
	}

	public static List<DoctorsAvailabilityDO> toDOList(List<DoctorsAvailabilityBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
		}

		List<DoctorsAvailabilityDO> doList = Lists.newArrayList();
		for (DoctorsAvailabilityBO doctorsAvailabilityBO : boList) {
			if (doctorsAvailabilityBO != null) {
				doList.add(toDO(doctorsAvailabilityBO));
			}
		}
		return doList;
	}

}
