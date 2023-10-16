package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.DoctorsBO;
import com.google.common.collect.Lists;
import com.iaminca.entity.dto.DoctorsDTO;
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
public class DoctorsConvert {

	public static DoctorsBO toBO(DoctorsDTO doctorsDTO) {
        if (doctorsDTO == null) {
            return null;
        }

		DoctorsBO doctorsBO = new DoctorsBO();
        BeanUtils.copyProperties(doctorsBO, doctorsDTO);
		return doctorsBO;
	}

	public static DoctorsDTO toDTO(DoctorsBO doctorsBO) {
        if (doctorsBO == null) {
            return null;
        }

		DoctorsDTO doctorsDTO = new DoctorsDTO();
        BeanUtils.copyProperties(doctorsDTO, doctorsBO);
		return doctorsDTO;
	}

	public static List<DoctorsBO> toBOList(List<DoctorsDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
			return Collections.emptyList();
		}

		List<DoctorsBO> boList = Lists.newArrayList();
		for (DoctorsDTO doctorsDTO : dtoList) {
			if (doctorsDTO != null) {
				boList.add(toBO(doctorsDTO));
			}
		}
		return boList;
	}

	public static List<DoctorsDTO> toDTOList(List<DoctorsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
			return Collections.emptyList();
		}

		List<DoctorsDTO> dtoList = Lists.newArrayList();
		for (DoctorsBO doctorsBO : boList) {
			if (doctorsBO != null) {
				dtoList.add(toDTO(doctorsBO));
			}
		}
		return dtoList;
	}

}
