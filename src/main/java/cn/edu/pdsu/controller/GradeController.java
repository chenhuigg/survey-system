package cn.edu.pdsu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.pdsu.pojo.AjaxResult;
import cn.edu.pdsu.pojo.Grade;
import cn.edu.pdsu.service.GradeService;

@RestController
@RequestMapping("/admin")
public class GradeController {
	@Autowired
	private GradeService gradeService;
	
	//获取全部年级
	@RequestMapping(value="/grade",method=RequestMethod.GET)
	public Object getAllGrade() {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			List<Grade> grades = gradeService.getAllGrade();
			ajaxResult.setData(grades);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}

}
