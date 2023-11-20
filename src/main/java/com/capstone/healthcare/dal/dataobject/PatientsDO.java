package com.capstone.healthcare.dal.dataobject;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Date;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@Entity(name = "patients")
public class PatientsDO {
	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
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
}
