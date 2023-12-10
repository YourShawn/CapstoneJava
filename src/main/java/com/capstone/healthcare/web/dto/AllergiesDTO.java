package com.capstone.healthcare.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@Data
public class AllergiesDTO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer allergyId;
	/***/
	private Integer patientId;
	/***/
	@JsonProperty("allergen_name")
	private String allergenName;

	@JsonProperty("allergy_type")
	private String allergyType;

	/***/
	private String severity;
	/***/
	private String notes;
}
