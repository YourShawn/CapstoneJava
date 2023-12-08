package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.PrescriptionsBO;
import com.google.common.collect.Lists;
import com.iaminca.entity.dto.PrescriptionsDTO;
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
public class PrescriptionsConvert {

	public static PrescriptionsBO toBO(PrescriptionsDTO prescriptionsDTO) {
        if (prescriptionsDTO == null) {
            return null;
        }

		PrescriptionsBO prescriptionsBO = new PrescriptionsBO();
        BeanUtils.copyProperties(prescriptionsDTO,prescriptionsBO);
		return prescriptionsBO;
	}

	public static PrescriptionsDTO toDTO(PrescriptionsBO prescriptionsBO) {
        if (prescriptionsBO == null) {
            return null;
        }

		PrescriptionsDTO prescriptionsDTO = new PrescriptionsDTO();
        BeanUtils.copyProperties(prescriptionsBO,prescriptionsDTO);
		return prescriptionsDTO;
	}

	public static List<PrescriptionsBO> toBOList(List<PrescriptionsDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
			return Collections.emptyList();
		}

		List<PrescriptionsBO> boList = Lists.newArrayList();
		for (PrescriptionsDTO prescriptionsDTO : dtoList) {
			if (prescriptionsDTO != null) {
				boList.add(toBO(prescriptionsDTO));
			}
		}
		return boList;
	}

	public static List<PrescriptionsDTO> toDTOList(List<PrescriptionsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
			return Collections.emptyList();
		}

		List<PrescriptionsDTO> dtoList = Lists.newArrayList();
		for (PrescriptionsBO prescriptionsBO : boList) {
			if (prescriptionsBO != null) {
				dtoList.add(toDTO(prescriptionsBO));
			}
		}
		return dtoList;
	}

}
