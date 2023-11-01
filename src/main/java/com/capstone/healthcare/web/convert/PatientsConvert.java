package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.PatientsBO;
import com.capstone.healthcare.web.dto.PatientsDTO;
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
 * @date 2023-10-16 14:42:09
 */
public class PatientsConvert {

	public static PatientsBO toBO(PatientsDTO patientsDTO) {
        if (patientsDTO == null) {
            return null;
        }

		PatientsBO patientsBO = new PatientsBO();
        BeanUtils.copyProperties(patientsDTO,patientsBO);
		return patientsBO;
	}

	public static PatientsDTO toDTO(PatientsBO patientsBO) {
        if (patientsBO == null) {
            return null;
        }

		PatientsDTO patientsDTO = new PatientsDTO();
        BeanUtils.copyProperties(patientsBO,patientsDTO);
		return patientsDTO;
	}

	public static List<PatientsBO> toBOList(List<PatientsDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
			return Collections.emptyList();
		}

		List<PatientsBO> boList = Lists.newArrayList();
		for (PatientsDTO patientsDTO : dtoList) {
			if (patientsDTO != null) {
				boList.add(toBO(patientsDTO));
			}
		}
		return boList;
	}

	public static List<PatientsDTO> toDTOList(List<PatientsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
			return Collections.emptyList();
		}

		List<PatientsDTO> dtoList = Lists.newArrayList();
		for (PatientsBO patientsBO : boList) {
			if (patientsBO != null) {
				dtoList.add(toDTO(patientsBO));
			}
		}
		return dtoList;
	}

}
