package com.capstone.healthcare.dal.dataobject;

import com.querydsl.core.types.PathMetadataFactory;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import java.util.Date;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
public class QPrescriptionsDO extends EntityPathBase<PrescriptionsDO> {
	private static final long serialVersionUID = 1L;

	public static final QPrescriptionsDO qPrescriptionsDO = new QPrescriptionsDO("qPrescriptionsDO");

//	public QPrescriptionsDO(Class<? extends PrescriptionsDO> type, String variable) {
//		super(type, variable);
//	}

//	public final NumberPath<Integer> prescriptionId = createNumber("prescriptionId", Integer.class);
//	public final StringPath notes = createString("notes");
//	public final DateTimePath<Date> prescriptionDate = createDateTime("prescriptionDate", Date.class);
//
	public QPrescriptionsDO(String variable) {
		super(PrescriptionsDO.class, PathMetadataFactory.forVariable(variable));
	}
}
