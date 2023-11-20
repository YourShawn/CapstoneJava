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
@Entity(name = "prescriptions")
public class PrescriptionsDO {
	private static final long serialVersionUID = 1L;

	/***/
	@Id
	@GeneratedValue
	private Integer prescriptionId;
	/***/
	private String notes;
	/***/
	private Date prescriptionDate;
}
