package com.capstone.healthcare.web.dto;

import lombok.Data;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
public class DoctorsDTO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer doctorId;
	/***/
	private String doctorName;
	/***/
	private String specialization;
	/***/
	private String address;
	/***/
	private String phoneNumber;
	/***/
	private int userId;
}
