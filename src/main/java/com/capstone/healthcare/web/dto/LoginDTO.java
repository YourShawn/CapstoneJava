package com.capstone.healthcare.web.dto;

import lombok.Data;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-17 02:51:37
 */
@Data
public class LoginDTO {
	private static final long serialVersionUID = 1L;

	/**user name*/
	private String username;
	/**Public key*/
	private String password;

}
