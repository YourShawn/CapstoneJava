package com.capstone.healthcare.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements ErrorCodeService {
	SUCCESS(200, "success"),
	UNKNOW_ERROR(9999, "System is busy, please try late!"),
	PARAM_IS_ERROR(10000, "Parameters should be not null!"),
	DATA_IS_EMPTY_ERROR(10001, "Data is noe exist"),
	WEB_HEADER_ERROR(10002, "No Authorized"),
	FREQUENT_OPERATION_ERROR(10003, "Too frequent operations, please try again later."),

	USER_PASSWORD_IS_ERROR(1100, "Account or password is incorrect"),

	//15500
	NO_AUTH(55555, "Please Login!"),
	SYS_TEM_ERROR(50000, "System error!"),
	;



	private final int code;
	private final String message;

}
