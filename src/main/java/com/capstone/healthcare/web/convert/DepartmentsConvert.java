package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.DepartmentsBO;
import com.google.common.collect.Lists;
import com.iaminca.entity.dto.DepartmentsDTO;
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
public class DepartmentsConvert {

	public static DepartmentsBO toBO(DepartmentsDTO departmentsDTO) {
        if (departmentsDTO == null) {
            return null;
        }

		DepartmentsBO departmentsBO = new DepartmentsBO();
        BeanUtils.copyProperties(departmentsBO, departmentsDTO);
		return departmentsBO;
	}

	public static DepartmentsDTO toDTO(DepartmentsBO departmentsBO) {
        if (departmentsBO == null) {
            return null;
        }

		DepartmentsDTO departmentsDTO = new DepartmentsDTO();
        BeanUtils.copyProperties(departmentsDTO, departmentsBO);
		return departmentsDTO;
	}

	public static List<DepartmentsBO> toBOList(List<DepartmentsDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
			return Collections.emptyList();
		}

		List<DepartmentsBO> boList = Lists.newArrayList();
		for (DepartmentsDTO departmentsDTO : dtoList) {
			if (departmentsDTO != null) {
				boList.add(toBO(departmentsDTO));
			}
		}
		return boList;
	}

	public static List<DepartmentsDTO> toDTOList(List<DepartmentsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
			return Collections.emptyList();
		}

		List<DepartmentsDTO> dtoList = Lists.newArrayList();
		for (DepartmentsBO departmentsBO : boList) {
			if (departmentsBO != null) {
				dtoList.add(toDTO(departmentsBO));
			}
		}
		return dtoList;
	}

}
