package com.capstone.healthcare.query;


import com.capstone.healthcare.common.modules.PageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Object for querying
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PatientsQuery extends PageInfo{
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
	private String assignedDoctor;
}
