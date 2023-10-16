package com.capstone.healthcare.dal.dataobject;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Data
public class LaboratoryTestsDO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer testid;
	/***/
	private String testName;
	/***/
	private String description;
	/***/
	private BigDecimal cost;
}
