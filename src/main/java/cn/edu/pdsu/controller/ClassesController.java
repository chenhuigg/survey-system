package cn.edu.pdsu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.pdsu.pojo.AjaxResult;
import cn.edu.pdsu.pojo.Classes;
import cn.edu.pdsu.service.ClassesService;

@RestController
@RequestMapping("/admin")
public class ClassesController {
	@Autowired
	private ClassesService classesService;
	
	@RequestMapping(value="/classes",method=RequestMethod.GET)
	public Object getClassesByMajorIdAndGradeId(String major,String grade) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			Map<String, String> map=new HashMap<String, String>();
			map.put("major", major);
			map.put("grade",grade);
			List<Classes> classeses= classesService.getClassesByGradeIdAndMajorId(map);
			ajaxResult.setData(classeses);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	

}
