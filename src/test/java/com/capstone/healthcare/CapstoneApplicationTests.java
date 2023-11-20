package com.capstone.healthcare;

import com.capstone.healthcare.common.Constants;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.PrescriptionsDO;
import com.capstone.healthcare.dal.jpa.PrescriptionsJPA2;
import com.capstone.healthcare.handle.AllergiesHandler;
import com.capstone.healthcare.query.AllergiesQuery;
import com.capstone.healthcare.service.AllergiesService;
import com.capstone.healthcare.service.bo.AllergiesBO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = CapstoneApplication.class)
class CapstoneApplicationTests {

	@Resource
	private AllergiesService allergiesService;
	@Resource
	private AllergiesHandler allergiesHandler;
	@Test
	void contextLoads() {
		AllergiesQuery query = new AllergiesQuery();
		query.setAllergyId(1);
		List<AllergiesBO> list = allergiesService.findList(query);
		System.out.println(Constants.GSON.toJson(list));
	}


	@Test
	void page() {
		AllergiesQuery query = new AllergiesQuery();
		query.setPatientId(1);
		PageListResult<AllergiesBO> page = allergiesService.findPage(query);
		System.out.println(Constants.GSON.toJson(page));
	}
	@Test
	void update() {
		AllergiesBO bo = new AllergiesBO();
		bo.setAllergyId(1);
		bo.setNotes("909091");
		allergiesHandler.update(bo);
		System.out.println("Done!");
	}
	@Resource
	private PrescriptionsJPA2 prescriptionsJPA2;
	@Test
	void group() {
		AllergiesBO bo = new AllergiesBO();
		bo.setAllergyId(1);
		bo.setNotes("909091");
		List<PrescriptionsDO> allByOrderByPrescriptionId = prescriptionsJPA2.findAllByOrderByPrescriptionId();
		System.out.println("Done!{}"+Constants.GSON.toJson(allByOrderByPrescriptionId));
		List<Object[]> allByOrderByPrescriptionId2= prescriptionsJPA2.groupByYear();
		System.out.println("Done!{}"+Constants.GSON.toJson(allByOrderByPrescriptionId2));
	}
}
