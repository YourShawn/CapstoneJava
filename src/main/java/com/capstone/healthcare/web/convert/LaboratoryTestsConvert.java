package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.LaboratoryTestsBO;
import com.google.common.collect.Lists;
import com.iaminca.entity.dto.LaboratoryTestsDTO;
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
public class LaboratoryTestsConvert {

	public static LaboratoryTestsBO toBO(LaboratoryTestsDTO laboratoryTestsDTO) {
        if (laboratoryTestsDTO == null) {
            return null;
        }

		LaboratoryTestsBO laboratoryTestsBO = new LaboratoryTestsBO();
        BeanUtils.copyProperties(laboratoryTestsBO, laboratoryTestsDTO);
		return laboratoryTestsBO;
	}

	public static LaboratoryTestsDTO toDTO(LaboratoryTestsBO laboratoryTestsBO) {
        if (laboratoryTestsBO == null) {
            return null;
        }

		LaboratoryTestsDTO laboratoryTestsDTO = new LaboratoryTestsDTO();
        BeanUtils.copyProperties(laboratoryTestsDTO, laboratoryTestsBO);
		return laboratoryTestsDTO;
	}

	public static List<LaboratoryTestsBO> toBOList(List<LaboratoryTestsDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
			return Collections.emptyList();
		}

		List<LaboratoryTestsBO> boList = Lists.newArrayList();
		for (LaboratoryTestsDTO laboratoryTestsDTO : dtoList) {
			if (laboratoryTestsDTO != null) {
				boList.add(toBO(laboratoryTestsDTO));
			}
		}
		return boList;
	}

	public static List<LaboratoryTestsDTO> toDTOList(List<LaboratoryTestsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
			return Collections.emptyList();
		}

		List<LaboratoryTestsDTO> dtoList = Lists.newArrayList();
		for (LaboratoryTestsBO laboratoryTestsBO : boList) {
			if (laboratoryTestsBO != null) {
				dtoList.add(toDTO(laboratoryTestsBO));
			}
		}
		return dtoList;
	}

}
