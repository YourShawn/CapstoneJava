package com.capstone.healthcare.dal.dataobject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@Entity(name = "allergies")
public class AllergiesDO {
	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
	private Integer allergyId;
	/***/
	private Integer patientId;
	/***/
	private String allergenName;
	/***/
	private String allergyType;
	/***/
	private String severity;
	/***/
	private String notes;
}
