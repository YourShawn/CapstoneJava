package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.MedicalRecordsDO;
import com.capstone.healthcare.service.bo.MedicalRecordsBO;
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
public class MedicalRecordsConvert {

	public static MedicalRecordsBO toBO(MedicalRecordsDO medicalRecordsDO) {
		if (medicalRecordsDO == null) {
            return null;
        }

		MedicalRecordsBO medicalRecordsBO = new MedicalRecordsBO();
        BeanUtils.copyProperties(medicalRecordsDO, medicalRecordsBO);
		return medicalRecordsBO;
	}

	public static MedicalRecordsDO toDO(MedicalRecordsBO medicalRecordsBO) {
        if (medicalRecordsBO == null) {
            return null;
        }

		MedicalRecordsDO medicalRecordsDO = new MedicalRecordsDO();
        BeanUtils.copyProperties(medicalRecordsBO, medicalRecordsDO);
		return medicalRecordsDO;
	}

	public static List<MedicalRecordsBO> toBOList(List<MedicalRecordsDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<MedicalRecordsBO> boList = Lists.newArrayList();
		for (MedicalRecordsDO medicalRecordsDO : doList) {
			if (medicalRecordsDO != null) {
				boList.add(toBO(medicalRecordsDO));
			}
		}
		return boList;
	}

	public static List<MedicalRecordsDO> toDOList(List<MedicalRecordsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
		}

		List<MedicalRecordsDO> doList = Lists.newArrayList();
		for (MedicalRecordsBO medicalRecordsBO : boList) {
			if (medicalRecordsBO != null) {
				doList.add(toDO(medicalRecordsBO));
			}
		}
		return doList;
	}

}
