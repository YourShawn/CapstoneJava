package com.capstone.healthcare.dal.dataobject;

import lombok.Data;
import java.util.Date;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Data
public class DepartmentsDO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer departmentid;
	/***/
	private String departmentName;
	/***/
	private String description;
}
