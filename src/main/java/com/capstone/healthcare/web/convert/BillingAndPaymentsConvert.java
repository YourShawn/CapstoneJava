package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.BillingAndPaymentsBO;
import com.google.common.collect.Lists;
import com.iaminca.entity.dto.BillingAndPaymentsDTO;
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
public class BillingAndPaymentsConvert {

	public static BillingAndPaymentsBO toBO(BillingAndPaymentsDTO billingAndPaymentsDTO) {
        if (billingAndPaymentsDTO == null) {
            return null;
        }

		BillingAndPaymentsBO billingAndPaymentsBO = new BillingAndPaymentsBO();
        BeanUtils.copyProperties(billingAndPaymentsBO, billingAndPaymentsDTO);
		return billingAndPaymentsBO;
	}

	public static BillingAndPaymentsDTO toDTO(BillingAndPaymentsBO billingAndPaymentsBO) {
        if (billingAndPaymentsBO == null) {
            return null;
        }

		BillingAndPaymentsDTO billingAndPaymentsDTO = new BillingAndPaymentsDTO();
        BeanUtils.copyProperties(billingAndPaymentsDTO, billingAndPaymentsBO);
		return billingAndPaymentsDTO;
	}

	public static List<BillingAndPaymentsBO> toBOList(List<BillingAndPaymentsDTO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
			return Collections.emptyList();
		}

		List<BillingAndPaymentsBO> boList = Lists.newArrayList();
		for (BillingAndPaymentsDTO billingAndPaymentsDTO : dtoList) {
			if (billingAndPaymentsDTO != null) {
				boList.add(toBO(billingAndPaymentsDTO));
			}
		}
		return boList;
	}

	public static List<BillingAndPaymentsDTO> toDTOList(List<BillingAndPaymentsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
			return Collections.emptyList();
		}

		List<BillingAndPaymentsDTO> dtoList = Lists.newArrayList();
		for (BillingAndPaymentsBO billingAndPaymentsBO : boList) {
			if (billingAndPaymentsBO != null) {
				dtoList.add(toDTO(billingAndPaymentsBO));
			}
		}
		return dtoList;
	}

}
