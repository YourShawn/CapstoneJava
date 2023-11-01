package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.PatientsDO;
import com.capstone.healthcare.service.bo.PatientsBO;
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
public class PatientsConvert {

	public static PatientsBO toBO(PatientsDO patientsDO) {
		if (patientsDO == null) {
            return null;
        }

		PatientsBO patientsBO = new PatientsBO();
        BeanUtils.copyProperties(patientsDO, patientsBO);
		return patientsBO;
	}

	public static PatientsDO toDO(PatientsBO patientsBO) {
        if (patientsBO == null) {
            return null;
        }

		PatientsDO patientsDO = new PatientsDO();
        BeanUtils.copyProperties(patientsBO, patientsDO);
		return patientsDO;
	}

	public static List<PatientsBO> toBOList(List<PatientsDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<PatientsBO> boList = Lists.newArrayList();
		for (PatientsDO patientsDO : doList) {
			if (patientsDO != null) {
				boList.add(toBO(patientsDO));
			}
		}
		return boList;
	}

	public static List<PatientsDO> toDOList(List<PatientsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
		}

		List<PatientsDO> doList = Lists.newArrayList();
		for (PatientsBO patientsBO : boList) {
			if (patientsBO != null) {
				doList.add(toDO(patientsBO));
			}
		}
		return doList;
	}

}
