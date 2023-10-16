package com.capstone.healthcare.service.bo;

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
public class NursesBO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer nurseId;
	/***/
	private String firstName;
	/***/
	private String lastName;
	/***/
	private String contactInformation;
	/***/
	private Integer departmentId;
}
