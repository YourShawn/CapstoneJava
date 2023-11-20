package com.capstone.healthcare.handle;

import com.capstone.healthcare.service.AllergiesService;
import com.capstone.healthcare.service.bo.AllergiesBO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * Doctors functionalities
 *
 *
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Component
public class AllergiesHandler {

	@Resource
	private AllergiesService allergiesService;



    public void update(AllergiesBO updateParameterBO){
        AllergiesBO bo = allergiesService.findBtId(updateParameterBO.getAllergyId());
        bo.setNotes(updateParameterBO.getNotes());
        allergiesService.update(bo);
    }

}
