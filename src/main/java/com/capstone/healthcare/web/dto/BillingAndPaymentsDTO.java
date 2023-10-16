package com.iaminca.entity.dto;

import lombok.Data;
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
public class BillingAndPaymentsDTO {
	private static final long serialVersionUID = 1L;

	/***/
	private Integer billingId;
	/***/
	private Integer patientId;
	/***/
	private Integer doctorId;
	/***/
	private Integer appointmentId;
	/***/
	private Date billingDate;
	/***/
	private BigDecimal totalAmount;
	/***/
	private String paymentStatus;
	/***/
	private Date paymentDate;
}
