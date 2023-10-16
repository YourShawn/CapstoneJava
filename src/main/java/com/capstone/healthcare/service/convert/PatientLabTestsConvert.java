package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.PatientLabTestsDO;
import com.capstone.healthcare.service.bo.PatientLabTestsBO;
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
public class PatientLabTestsConvert {

	public static PatientLabTestsBO toBO(PatientLabTestsDO patientLabTestsDO) {
		if (patientLabTestsDO == null) {
            return null;
        }

		PatientLabTestsBO patientLabTestsBO = new PatientLabTestsBO();
        BeanUtils.copyProperties(patientLabTestsBO, patientLabTestsDO);
		return patientLabTestsBO;
	}

	public static PatientLabTestsDO toDO(PatientLabTestsBO patientLabTestsBO) {
        if (patientLabTestsBO == null) {
            return null;
        }

		PatientLabTestsDO patientLabTestsDO = new PatientLabTestsDO();
        BeanUtils.copyProperties(patientLabTestsDO, patientLabTestsBO);
		return patientLabTestsDO;
	}

	public static List<PatientLabTestsBO> toBOList(List<PatientLabTestsDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<PatientLabTestsBO> boList = Lists.newArrayList();
		for (PatientLabTestsDO patientLabTestsDO : doList) {
			if (patientLabTestsDO != null) {
				boList.add(toBO(patientLabTestsDO));
			}
		}
		return boList;
	}

	public static List<PatientLabTestsDO> toDOList(List<PatientLabTestsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
		}

		List<PatientLabTestsDO> doList = Lists.newArrayList();
		for (PatientLabTestsBO patientLabTestsBO : boList) {
			if (patientLabTestsBO != null) {
				doList.add(toDO(patientLabTestsBO));
			}
		}
		return doList;
	}

}
