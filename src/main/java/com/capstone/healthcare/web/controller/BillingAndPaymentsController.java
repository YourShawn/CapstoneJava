package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.BillingAndPaymentsQuery;
import com.capstone.healthcare.service.BillingAndPaymentsService;
import com.capstone.healthcare.service.bo.BillingAndPaymentsBO;
import com.capstone.healthcare.web.convert.BillingAndPaymentsConvert;
import com.iaminca.entity.dto.BillingAndPaymentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@RestController
@RequestMapping("/billingAndPayments")
public class BillingAndPaymentsController {
	@Autowired
	private BillingAndPaymentsService billingAndPaymentsService;


	
	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody BillingAndPaymentsQuery query){
		PageListResult<BillingAndPaymentsBO> pagerResult = billingAndPaymentsService.findPage(query);

		List<BillingAndPaymentsDTO> BillingAndPaymentsDTOS = BillingAndPaymentsConvert.toDTOList(pagerResult.getList());
		PageListResult<BillingAndPaymentsDTO> page = new PageListResult<>(BillingAndPaymentsDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}

	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody BillingAndPaymentsDTO billingAndPaymentsDTO){
		BillingAndPaymentsBO billingAndPaymentsBO = BillingAndPaymentsConvert.toBO(billingAndPaymentsDTO);
		billingAndPaymentsService.add(billingAndPaymentsBO);
        return new ResultModel();
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody BillingAndPaymentsDTO billingAndPaymentsDTO){
		BillingAndPaymentsBO billingAndPaymentsBO = BillingAndPaymentsConvert.toBO(billingAndPaymentsDTO);
		billingAndPaymentsService.update(billingAndPaymentsBO);
        return new ResultModel();
	}

}
