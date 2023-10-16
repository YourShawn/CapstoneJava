package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.PatientLabTestsBO;
import com.google.common.collect.Lists;
import com.iaminca.entity.dto.PatientLabTestsDTO;
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
public class PatientLabTestsConvert {

	public static PatientLabTestsBO toBO(PatientLabTestsDTO patientLabTestsDTO) {
        if (patientLabTestsDTO == null) {
            return null;
        }

		PatientLabTestsBO patientLabTestsBO = new PatientLabTestsBO();
        BeanUtils.copyProperties(patientLabTestsBO, patientLabTestsDTO);
		return patientLabTestsBO;
	}

	public static PatientLabTestsDTO toDTO(PatientLabTestsBO patientLabTestsBO) {
        if (patientLabTestsBO == null) {
            return null;
        }

		PatientLabTestsDTO patientLabTestsDTO = new PatientLabTestsDTO();
        BeanUtils.copyProperties(patientLabTestsDTO, patientLabTestsBO);
		return patientLabTestsDTO;
	}

	public static List<PatientLabTestsBO> toBOList(List<PatientLabTestsDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
			return Collections.emptyList();
		}

		List<PatientLabTestsBO> boList = Lists.newArrayList();
		for (PatientLabTestsDTO patientLabTestsDTO : dtoList) {
			if (patientLabTestsDTO != null) {
				boList.add(toBO(patientLabTestsDTO));
			}
		}
		return boList;
	}

	public static List<PatientLabTestsDTO> toDTOList(List<PatientLabTestsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
			return Collections.emptyList();
		}

		List<PatientLabTestsDTO> dtoList = Lists.newArrayList();
		for (PatientLabTestsBO patientLabTestsBO : boList) {
			if (patientLabTestsBO != null) {
				dtoList.add(toDTO(patientLabTestsBO));
			}
		}
		return dtoList;
	}

}
