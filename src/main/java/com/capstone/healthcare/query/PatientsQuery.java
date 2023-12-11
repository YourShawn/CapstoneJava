package com.capstone.healthcare.query;


import com.capstone.healthcare.common.modules.PageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

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
	private List<Integer> patientIdList;
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
	/***/
	private String bloodGroup;
	/***/
	private String patientHistory;
	/***/
	private String maritalStatus;
	/***/
	private String userId;
}
