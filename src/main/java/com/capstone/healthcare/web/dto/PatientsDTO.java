package com.capstone.healthcare.web.dto;

import lombok.Data;

import java.util.Date;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
public class PatientsDTO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer patientId;
	/***/
	private String firstName;
	/***/
	private String lastName;
	/***/
	private String phoneNumber;
	/***/
	private String address;
	/***/
	private Date dateOfBirth;
	/***/
	private String gender;
	/***/
	private String healthCardId;
	/***/
	private String haveAllergies;
	/***/
	private Integer assignedDoctor;
	/***/
	private String bloodGroup;
	/***/
	private String patientHistory;
	/***/
	private String maritalStatus;
}
