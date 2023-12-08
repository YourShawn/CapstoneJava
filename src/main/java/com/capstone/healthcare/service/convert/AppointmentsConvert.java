package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.AppointmentsDO;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.bo.AppointmentsByPatientNameBO;
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
public class AppointmentsConvert {

	public static AppointmentsBO toBO(AppointmentsDO appointmentsDO) {
		if (appointmentsDO == null) {
            return null;
        }

		AppointmentsBO appointmentsBO = new AppointmentsBO();
        BeanUtils.copyProperties(appointmentsDO, appointmentsBO);
		return appointmentsBO;
	}

	public static AppointmentsDO toDO(AppointmentsBO appointmentsBO) {
        if (appointmentsBO == null) {
            return null;
        }
		AppointmentsDO appointmentsDO = new AppointmentsDO();

		if (appointmentsBO.getAppointmentId() != null ) {
			// Update only the specified fields from the request
			if (appointmentsBO.getIsActive() != null) {
				appointmentsDO.setIsActive(appointmentsBO.getIsActive());
			}
		} else {
			BeanUtils.copyProperties(appointmentsBO, appointmentsDO);
		}
		return appointmentsDO;
	}

	public static List<AppointmentsBO> toBOList(List<AppointmentsDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
			return Collections.emptyList();
		}
		List<AppointmentsBO> boList = Lists.newArrayList();
		for (AppointmentsDO appointmentsDO : doList) {
			if (appointmentsDO != null) {
				boList.add(toBO(appointmentsDO));
			}
		}
		return boList;
	}

	public static List<AppointmentsDO> toDOList(List<AppointmentsBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
		}

		List<AppointmentsDO> doList = Lists.newArrayList();
		for (AppointmentsBO appointmentsBO : boList) {
			if (appointmentsBO != null) {
				doList.add(toDO(appointmentsBO));
			}
		}
		return doList;
	}



}
