package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.web.dto.AppointmentsDTO;
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
public class AppointmentsConvert {

	public static AppointmentsBO toBO(AppointmentsDTO appointmentsDTO) {
        if (appointmentsDTO == null) {
            return null;
        }

		AppointmentsBO appointmentsBO = new AppointmentsBO();
        BeanUtils.copyProperties(appointmentsDTO, appointmentsBO);
		return appointmentsBO;
	}

	public static AppointmentsDTO toDTO(AppointmentsBO appointmentsBO) {
        if (appointmentsBO == null) {
            return null;
        }

		AppointmentsDTO appointmentsDTO = new AppointmentsDTO();
        BeanUtils.copyProperties(appointmentsBO, appointmentsDTO);
		return appointmentsDTO;
	}

	public static List<AppointmentsBO> toBOList(List<AppointmentsDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
			return Collections.emptyList();
		}

		List<AppointmentsBO> boList = Lists.newArrayList();
		for (AppointmentsDTO appointmentsDTO : dtoList) {
			if (appointmentsDTO != null) {
				boList.add(toBO(appointmentsDTO));
			}
		}
		return boList;
	}

	public static List<AppointmentsDTO> toDTOList(List<AppointmentsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
			return Collections.emptyList();
		}

		List<AppointmentsDTO> dtoList = Lists.newArrayList();
		for (AppointmentsBO appointmentsBO : boList) {
			if (appointmentsBO != null) {
				dtoList.add(toDTO(appointmentsBO));
			}
		}
		return dtoList;
	}

}
