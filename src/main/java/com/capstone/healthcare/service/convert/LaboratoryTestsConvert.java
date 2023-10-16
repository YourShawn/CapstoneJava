package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.LaboratoryTestsDO;
import com.capstone.healthcare.service.bo.LaboratoryTestsBO;
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
public class LaboratoryTestsConvert {

	public static LaboratoryTestsBO toBO(LaboratoryTestsDO laboratoryTestsDO) {
		if (laboratoryTestsDO == null) {
            return null;
        }

		LaboratoryTestsBO laboratoryTestsBO = new LaboratoryTestsBO();
        BeanUtils.copyProperties(laboratoryTestsBO, laboratoryTestsDO);
		return laboratoryTestsBO;
	}

	public static LaboratoryTestsDO toDO(LaboratoryTestsBO laboratoryTestsBO) {
        if (laboratoryTestsBO == null) {
            return null;
        }

		LaboratoryTestsDO laboratoryTestsDO = new LaboratoryTestsDO();
        BeanUtils.copyProperties(laboratoryTestsDO, laboratoryTestsBO);
		return laboratoryTestsDO;
	}

	public static List<LaboratoryTestsBO> toBOList(List<LaboratoryTestsDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<LaboratoryTestsBO> boList = Lists.newArrayList();
		for (LaboratoryTestsDO laboratoryTestsDO : doList) {
			if (laboratoryTestsDO != null) {
				boList.add(toBO(laboratoryTestsDO));
			}
		}
		return boList;
	}

	public static List<LaboratoryTestsDO> toDOList(List<LaboratoryTestsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
		}

		List<LaboratoryTestsDO> doList = Lists.newArrayList();
		for (LaboratoryTestsBO laboratoryTestsBO : boList) {
			if (laboratoryTestsBO != null) {
				doList.add(toDO(laboratoryTestsBO));
			}
		}
		return doList;
	}

}
