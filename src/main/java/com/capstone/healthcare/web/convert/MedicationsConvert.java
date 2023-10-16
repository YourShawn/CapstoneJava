package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.MedicationsBO;
import com.google.common.collect.Lists;
import com.iaminca.entity.dto.MedicationsDTO;
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
public class MedicationsConvert {

	public static MedicationsBO toBO(MedicationsDTO medicationsDTO) {
        if (medicationsDTO == null) {
            return null;
        }

		MedicationsBO medicationsBO = new MedicationsBO();
        BeanUtils.copyProperties(medicationsBO, medicationsDTO);
		return medicationsBO;
	}

	public static MedicationsDTO toDTO(MedicationsBO medicationsBO) {
        if (medicationsBO == null) {
            return null;
        }

		MedicationsDTO medicationsDTO = new MedicationsDTO();
        BeanUtils.copyProperties(medicationsDTO, medicationsBO);
		return medicationsDTO;
	}

	public static List<MedicationsBO> toBOList(List<MedicationsDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
			return Collections.emptyList();
		}

		List<MedicationsBO> boList = Lists.newArrayList();
		for (MedicationsDTO medicationsDTO : dtoList) {
			if (medicationsDTO != null) {
				boList.add(toBO(medicationsDTO));
			}
		}
		return boList;
	}

	public static List<MedicationsDTO> toDTOList(List<MedicationsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
			return Collections.emptyList();
		}

		List<MedicationsDTO> dtoList = Lists.newArrayList();
		for (MedicationsBO medicationsBO : boList) {
			if (medicationsBO != null) {
				dtoList.add(toDTO(medicationsBO));
			}
		}
		return dtoList;
	}

}
