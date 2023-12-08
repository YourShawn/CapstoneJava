package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.MedicalRecordsBO;
import com.google.common.collect.Lists;
import com.iaminca.entity.dto.MedicalRecordsDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
public class MedicalRecordsConvert {

	public static MedicalRecordsBO toBO(MedicalRecordsDTO medicalRecordsDTO) {
        if (medicalRecordsDTO == null) {
            return null;
        }

		MedicalRecordsBO medicalRecordsBO = new MedicalRecordsBO();
        BeanUtils.copyProperties(medicalRecordsDTO,medicalRecordsBO);
		return medicalRecordsBO;
	}

	public static MedicalRecordsDTO toDTO(MedicalRecordsBO medicalRecordsBO) {
        if (medicalRecordsBO == null) {
            return null;
        }

		MedicalRecordsDTO medicalRecordsDTO = new MedicalRecordsDTO();
        BeanUtils.copyProperties(medicalRecordsBO, medicalRecordsDTO);
		return medicalRecordsDTO;
	}

	public static List<MedicalRecordsBO> toBOList(List<MedicalRecordsDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
			return Collections.emptyList();
		}

		List<MedicalRecordsBO> boList = Lists.newArrayList();
		for (MedicalRecordsDTO medicalRecordsDTO : dtoList) {
			if (medicalRecordsDTO != null) {
				boList.add(toBO(medicalRecordsDTO));
			}
		}
		return boList;
	}

	public static List<MedicalRecordsDTO> toDTOList(List<MedicalRecordsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
			return Collections.emptyList();
		}

		List<MedicalRecordsDTO> dtoList = Lists.newArrayList();
		for (MedicalRecordsBO medicalRecordsBO : boList) {
			if (medicalRecordsBO != null) {
				dtoList.add(toDTO(medicalRecordsBO));
			}
		}
		return dtoList;
	}

}
