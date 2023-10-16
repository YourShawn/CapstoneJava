package com.iaminca.entity.dto;

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
public class NursesDTO {
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
