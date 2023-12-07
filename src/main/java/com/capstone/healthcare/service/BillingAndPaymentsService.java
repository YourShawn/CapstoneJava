package com.capstone.healthcare.service;

import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.BillingAndPaymentsQuery;
import com.capstone.healthcare.service.bo.BillingAndPaymentsBO;

import java.util.List;
/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
public interface BillingAndPaymentsService {

    /**
	 * @param
	 * @return
	 */
    void add(BillingAndPaymentsBO billingAndPaymentsBO);

    /**
     * @param
     * @return
     */
    void update(BillingAndPaymentsBO billingAndPaymentsBO);


    /**
     * query
     * @param query
     * @return
     */
    List<BillingAndPaymentsBO> findList(BillingAndPaymentsQuery query);

    PageListResult<BillingAndPaymentsBO> findPage(BillingAndPaymentsQuery query);
}
