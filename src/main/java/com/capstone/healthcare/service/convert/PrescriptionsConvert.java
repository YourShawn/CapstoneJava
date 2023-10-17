package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.PrescriptionsDO;
import com.capstone.healthcare.service.bo.PrescriptionsBO;
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
public class PrescriptionsConvert {

	public static PrescriptionsBO toBO(PrescriptionsDO prescriptionsDO) {
		if (prescriptionsDO == null) {
            return null;
        }

		PrescriptionsBO prescriptionsBO = new PrescriptionsBO();
        BeanUtils.copyProperties(prescriptionsBO, prescriptionsDO);
		return prescriptionsBO;
	}

	public static PrescriptionsDO toDO(PrescriptionsBO prescriptionsBO) {
        if (prescriptionsBO == null) {
            return null;
        }

		PrescriptionsDO prescriptionsDO = new PrescriptionsDO();
        BeanUtils.copyProperties(prescriptionsBO,prescriptionsDO);
		return prescriptionsDO;
	}

	public static List<PrescriptionsBO> toBOList(List<PrescriptionsDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<PrescriptionsBO> boList = Lists.newArrayList();
		for (PrescriptionsDO prescriptionsDO : doList) {
			if (prescriptionsDO != null) {
				boList.add(toBO(prescriptionsDO));
			}
		}
		return boList;
	}

	public static List<PrescriptionsDO> toDOList(List<PrescriptionsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
		}

		List<PrescriptionsDO> doList = Lists.newArrayList();
		for (PrescriptionsBO prescriptionsBO : boList) {
			if (prescriptionsBO != null) {
				doList.add(toDO(prescriptionsBO));
			}
		}
		return doList;
	}

}
