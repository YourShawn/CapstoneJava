package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.AllergiesBO;
import com.capstone.healthcare.web.dto.AllergiesDTO;
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
public class AllergiesConvert {

	public static AllergiesBO toBO(AllergiesDTO allergiesDTO) {
        if (allergiesDTO == null) {
            return null;
        }


		AllergiesBO allergiesBO = new AllergiesBO();
        BeanUtils.copyProperties(allergiesDTO, allergiesBO);
		return allergiesBO;
	}

	public static AllergiesDTO toDTO(AllergiesBO allergiesBO) {
        if (allergiesBO == null) {
            return null;
        }

		AllergiesDTO allergiesDTO = new AllergiesDTO();
        BeanUtils.copyProperties(allergiesBO, allergiesDTO);
		return allergiesDTO;
	}

	public static List<AllergiesBO> toBOList(List<AllergiesDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
			return Collections.emptyList();
		}

		List<AllergiesBO> boList = Lists.newArrayList();
		for (AllergiesDTO allergiesDTO : dtoList) {
			if (allergiesDTO != null) {
				boList.add(toBO(allergiesDTO));
			}
		}
		return boList;
	}

	public static List<AllergiesDTO> toDTOList(List<AllergiesBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
			return Collections.emptyList();
		}

		List<AllergiesDTO> dtoList = Lists.newArrayList();
		for (AllergiesBO allergiesBO : boList) {
			if (allergiesBO != null) {
				dtoList.add(toDTO(allergiesBO));
			}
		}
		return dtoList;
	}

}
