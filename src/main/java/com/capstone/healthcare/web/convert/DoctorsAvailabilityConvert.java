package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.DoctorsAvailabilityBO;
import com.capstone.healthcare.web.dto.DoctorsAvailabilityDTO;
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
public class DoctorsAvailabilityConvert {

	public static DoctorsAvailabilityBO toBO(DoctorsAvailabilityDTO doctorsAvailabilityDTO) {
        if (doctorsAvailabilityDTO == null) {
            return null;
        }

		DoctorsAvailabilityBO doctorsAvailabilityBO = new DoctorsAvailabilityBO();
        BeanUtils.copyProperties(doctorsAvailabilityBO, doctorsAvailabilityDTO);
		return doctorsAvailabilityBO;
	}

	public static DoctorsAvailabilityDTO toDTO(DoctorsAvailabilityBO doctorsAvailabilityBO) {
        if (doctorsAvailabilityBO == null) {
            return null;
        }

		DoctorsAvailabilityDTO doctorsAvailabilityDTO = new DoctorsAvailabilityDTO();
        BeanUtils.copyProperties(doctorsAvailabilityDTO, doctorsAvailabilityBO);
		return doctorsAvailabilityDTO;
	}

	public static List<DoctorsAvailabilityBO> toBOList(List<DoctorsAvailabilityDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
			return Collections.emptyList();
		}

		List<DoctorsAvailabilityBO> boList = Lists.newArrayList();
		for (DoctorsAvailabilityDTO doctorsAvailabilityDTO : dtoList) {
			if (doctorsAvailabilityDTO != null) {
				boList.add(toBO(doctorsAvailabilityDTO));
			}
		}
		return boList;
	}

	public static List<DoctorsAvailabilityDTO> toDTOList(List<DoctorsAvailabilityBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
			return Collections.emptyList();
		}

		List<DoctorsAvailabilityDTO> dtoList = Lists.newArrayList();
		for (DoctorsAvailabilityBO doctorsAvailabilityBO : boList) {
			if (doctorsAvailabilityBO != null) {
				dtoList.add(toDTO(doctorsAvailabilityBO));
			}
		}
		return dtoList;
	}

}
