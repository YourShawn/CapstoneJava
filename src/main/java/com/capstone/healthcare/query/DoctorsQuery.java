package com.capstone.healthcare.query;


import lombok.Data;
import java.util.Date;
import com.capstone.healthcare.common.modules.PageInfo;
import lombok.EqualsAndHashCode;

/**
 * Object for querying
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DoctorsQuery extends PageInfo{
	private static final long serialVersionUID = 1L;

	/***/
	private Integer doctorId;
	/***/
	private String doctorName;
	/***/
	private String specialization;
	/***/
	private String address;
	/***/
	private String phoneNumber;
}
