package com.capstone.healthcare.dal.dataobject;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@Table(name = "laboratory_tests")
public class LaboratoryTestsDO {
	private static final long serialVersionUID = 1L;

	/***/
	@Id
	private Integer testId;
	/***/
	private String testName;
	/***/
	private String description;
	/***/
	private BigDecimal cost;
}
