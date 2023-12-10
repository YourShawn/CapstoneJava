package com.capstone.healthcare.dal.dataobject;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@Entity(name = "doctors")
public class DoctorsDO {
	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
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
