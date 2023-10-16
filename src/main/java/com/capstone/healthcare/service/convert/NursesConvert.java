package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.NursesDO;
import com.capstone.healthcare.service.bo.NursesBO;
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
public class NursesConvert {

	public static NursesBO toBO(NursesDO nursesDO) {
		if (nursesDO == null) {
            return null;
        }

		NursesBO nursesBO = new NursesBO();
        BeanUtils.copyProperties(nursesBO, nursesDO);
		return nursesBO;
	}

	public static NursesDO toDO(NursesBO nursesBO) {
        if (nursesBO == null) {
            return null;
        }

		NursesDO nursesDO = new NursesDO();
        BeanUtils.copyProperties(nursesDO, nursesBO);
		return nursesDO;
	}

	public static List<NursesBO> toBOList(List<NursesDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<NursesBO> boList = Lists.newArrayList();
		for (NursesDO nursesDO : doList) {
			if (nursesDO != null) {
				boList.add(toBO(nursesDO));
			}
		}
		return boList;
	}

	public static List<NursesDO> toDOList(List<NursesBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
		}

		List<NursesDO> doList = Lists.newArrayList();
		for (NursesBO nursesBO : boList) {
			if (nursesBO != null) {
				doList.add(toDO(nursesBO));
			}
		}
		return doList;
	}

}
