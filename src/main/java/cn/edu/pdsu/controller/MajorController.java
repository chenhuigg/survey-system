package cn.edu.pdsu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.pdsu.pojo.AjaxResult;
import cn.edu.pdsu.pojo.Major;
import cn.edu.pdsu.service.MajorService;

@RestController
@RequestMapping("/admin")
public class MajorController {
	@Autowired
	private MajorService majorService;
	
	//获得所有专业
	@RequestMapping(value="/major",method=RequestMethod.GET)
	public Object getAllMajor() {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			List<Major> majors = majorService.getAllMajor();
			ajaxResult.setData(majors);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}

}
