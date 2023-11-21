package com.capstone.healthcare.jpa;

import com.capstone.healthcare.CapstoneApplicationTests;
import com.capstone.healthcare.common.Constants;
import com.capstone.healthcare.service.PrescriptionsService;
import com.capstone.healthcare.service.bo.PrescriptionsByYearBO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProscriptionsJPATest extends CapstoneApplicationTests {

    @Resource
    private PrescriptionsService prescriptionsService;
    @Test
    void contextLoads() {
        List<PrescriptionsByYearBO> prescriptionGroupYear = prescriptionsService.findGroupYear();
        System.out.println(Constants.GSON.toJson(prescriptionGroupYear));
    }
}
