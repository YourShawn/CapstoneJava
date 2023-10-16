package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.NursesBO;
import com.google.common.collect.Lists;
import com.iaminca.entity.dto.NursesDTO;
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
public class NursesConvert {

	public static NursesBO toBO(NursesDTO nursesDTO) {
        if (nursesDTO == null) {
            return null;
        }

		NursesBO nursesBO = new NursesBO();
        BeanUtils.copyProperties(nursesBO, nursesDTO);
		return nursesBO;
	}

	public static NursesDTO toDTO(NursesBO nursesBO) {
        if (nursesBO == null) {
            return null;
        }

		NursesDTO nursesDTO = new NursesDTO();
        BeanUtils.copyProperties(nursesDTO, nursesBO);
		return nursesDTO;
	}

	public static List<NursesBO> toBOList(List<NursesDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
			return Collections.emptyList();
		}

		List<NursesBO> boList = Lists.newArrayList();
		for (NursesDTO nursesDTO : dtoList) {
			if (nursesDTO != null) {
				boList.add(toBO(nursesDTO));
			}
		}
		return boList;
	}

	public static List<NursesDTO> toDTOList(List<NursesBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
			return Collections.emptyList();
		}

		List<NursesDTO> dtoList = Lists.newArrayList();
		for (NursesBO nursesBO : boList) {
			if (nursesBO != null) {
				dtoList.add(toDTO(nursesBO));
			}
		}
		return dtoList;
	}

}
