package com.capstone.healthcare;

import com.capstone.healthcare.common.Constants;
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
	@Test
	void contextLoads() {
		AllergiesQuery query = new AllergiesQuery();
		query.setAllergyId(2);
		List<AllergiesBO> list = allergiesService.findList(query);
		System.out.println(Constants.GSON.toJson(list));
	}

}
