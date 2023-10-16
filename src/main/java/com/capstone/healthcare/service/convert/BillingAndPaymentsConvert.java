package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.BillingAndPaymentsDO;
import com.capstone.healthcare.service.bo.BillingAndPaymentsBO;
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
 * @date 2023-10-16 09:23:19
 */
public class BillingAndPaymentsConvert {

	public static BillingAndPaymentsBO toBO(BillingAndPaymentsDO billingAndPaymentsDO) {
		if (billingAndPaymentsDO == null) {
            return null;
        }

		BillingAndPaymentsBO billingAndPaymentsBO = new BillingAndPaymentsBO();
        BeanUtils.copyProperties(billingAndPaymentsBO, billingAndPaymentsDO);
		return billingAndPaymentsBO;
	}

	public static BillingAndPaymentsDO toDO(BillingAndPaymentsBO billingAndPaymentsBO) {
        if (billingAndPaymentsBO == null) {
            return null;
        }

		BillingAndPaymentsDO billingAndPaymentsDO = new BillingAndPaymentsDO();
        BeanUtils.copyProperties(billingAndPaymentsDO, billingAndPaymentsBO);
		return billingAndPaymentsDO;
	}

	public static List<BillingAndPaymentsBO> toBOList(List<BillingAndPaymentsDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<BillingAndPaymentsBO> boList = Lists.newArrayList();
		for (BillingAndPaymentsDO billingAndPaymentsDO : doList) {
			if (billingAndPaymentsDO != null) {
				boList.add(toBO(billingAndPaymentsDO));
			}
		}
		return boList;
	}

	public static List<BillingAndPaymentsDO> toDOList(List<BillingAndPaymentsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
		}

		List<BillingAndPaymentsDO> doList = Lists.newArrayList();
		for (BillingAndPaymentsBO billingAndPaymentsBO : boList) {
			if (billingAndPaymentsBO != null) {
				doList.add(toDO(billingAndPaymentsBO));
			}
		}
		return doList;
	}

}
