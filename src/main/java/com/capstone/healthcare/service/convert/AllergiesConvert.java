package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.AllergiesDO;
import com.capstone.healthcare.service.bo.AllergiesBO;
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
public class AllergiesConvert {

	public static AllergiesBO toBO(AllergiesDO allergiesDO) {
		if (allergiesDO == null) {
            return null;
        }

		AllergiesBO allergiesBO = new AllergiesBO();
        BeanUtils.copyProperties( allergiesDO,allergiesBO);
		return allergiesBO;
	}

	public static AllergiesDO toDO(AllergiesBO allergiesBO) {
        if (allergiesBO == null) {
            return null;
        }

		AllergiesDO allergiesDO = new AllergiesDO();
        BeanUtils.copyProperties(allergiesBO,allergiesDO);
		return allergiesDO;
	}

	public static List<AllergiesBO> toBOList(List<AllergiesDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<AllergiesBO> boList = Lists.newArrayList();
		for (AllergiesDO allergiesDO : doList) {
			if (allergiesDO != null) {
				boList.add(toBO(allergiesDO));
			}
		}
		return boList;
	}

	public static List<AllergiesDO> toDOList(List<AllergiesBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
		}

		List<AllergiesDO> doList = Lists.newArrayList();
		for (AllergiesBO allergiesBO : boList) {
			if (allergiesBO != null) {
				doList.add(toDO(allergiesBO));
			}
		}
		return doList;
	}

}
