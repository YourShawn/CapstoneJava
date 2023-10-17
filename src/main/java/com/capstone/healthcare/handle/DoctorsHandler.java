package com.capstone.healthcare.handle;

import com.capstone.healthcare.service.DoctorsService;
import com.capstone.healthcare.service.bo.DoctorsBO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 
 *
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Component
public class DoctorsHandler{

	@Resource
	private DoctorsService doctorsService;


    public void add(DoctorsBO doctorsBO){
        doctorsService.add(doctorsBO);
    }

}
