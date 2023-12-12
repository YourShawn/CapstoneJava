package com.capstone.healthcare.dal.dataobject;

import com.querydsl.core.types.PathMetadataFactory;
import com.querydsl.core.types.dsl.EntityPathBase;

public class QDoctorsDO extends EntityPathBase<DoctorsDO> {
    private static final long serialVersionUID = 1L;
    public static final QDoctorsDO qDoctorsDO = new QDoctorsDO("qDoctorsDO");

    public QDoctorsDO(String variable) {
        super(DoctorsDO.class, PathMetadataFactory.forVariable(variable));
    }
}
