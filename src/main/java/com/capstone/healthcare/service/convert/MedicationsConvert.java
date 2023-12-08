package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.MedicationsDO;
import com.capstone.healthcare.service.bo.MedicationsBO;
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
public class MedicationsConvert {

	public static MedicationsBO toBO(MedicationsDO medicationsDO) {
		if (medicationsDO == null) {
            return null;
        }

		MedicationsBO medicationsBO = new MedicationsBO();
        BeanUtils.copyProperties(medicationsDO, medicationsBO);
		return medicationsBO;
	}

	public static MedicationsDO toDO(MedicationsBO medicationsBO) {
        if (medicationsBO == null) {
            return null;
        }

		MedicationsDO medicationsDO = new MedicationsDO();
        BeanUtils.copyProperties(medicationsBO, medicationsDO);
		return medicationsDO;
	}

	public static List<MedicationsBO> toBOList(List<MedicationsDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<MedicationsBO> boList = Lists.newArrayList();
		for (MedicationsDO medicationsDO : doList) {
			if (medicationsDO != null) {
				boList.add(toBO(medicationsDO));
			}
		}
		return boList;
	}

	public static List<MedicationsDO> toDOList(List<MedicationsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
		}

		List<MedicationsDO> doList = Lists.newArrayList();
		for (MedicationsBO medicationsBO : boList) {
			if (medicationsBO != null) {
				doList.add(toDO(medicationsBO));
			}
		}
		return doList;
	}

}
