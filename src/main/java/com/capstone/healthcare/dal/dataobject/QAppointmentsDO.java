package com.capstone.healthcare.dal.dataobject;

import com.querydsl.core.types.PathMetadataFactory;
import com.querydsl.core.types.dsl.EntityPathBase;

/**
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
public class QAppointmentsDO extends EntityPathBase<AppointmentsDO> {
    private static final long serialVersionUID = 1L;
    public static final QAppointmentsDO qAppointmentsDO = new QAppointmentsDO("qAppointmentsDO");

    public QAppointmentsDO(String variable) {
        super(AppointmentsDO.class, PathMetadataFactory.forVariable(variable));
    }

}
