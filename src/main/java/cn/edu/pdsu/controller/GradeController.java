package cn.edu.pdsu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
	
	//专业和科目，获得它们所发布到的年级
	@RequestMapping(value="/grade-major-survey",method=RequestMethod.GET)
	public Object getWjByMajorIdAndGradeId(String major_id,String survey_id) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			Map<String, Object> map=new HashMap<>();
			map.put("survey_id", survey_id);
			map.put("major_id", major_id);
			List<Grade> grades= gradeService.getGradeBySurveyIdAndMajorId(map);
			ajaxResult.setData(grades);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
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
	
	//新增年级
	@RequestMapping(value="/grade",method=RequestMethod.POST)
	public Object addMajor(String name) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			String id=UUID.randomUUID().toString();
			String create_time=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("name", name);
			map.put("id", id);
			map.put("create_time", create_time);
			int i= gradeService.addGrade(map);
			if(i==1) {
				ajaxResult.setSuccess(true);
			}
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	//删除年级
	@RequestMapping(value="/grade",method=RequestMethod.DELETE)
	public Object delMajor(String id) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			int i= gradeService.delGrade(id);
			if(i==1) {
				ajaxResult.setSuccess(true);
			}
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	//更新年级
	@RequestMapping(value="/grade",method=RequestMethod.PUT)
	public Object updateMajor(String id,String name) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			Map<String, Object> map=new HashMap<>();
			map.put("id", id);
			map.put("name", name);
			map.put("create_time", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			int i= gradeService.updateGrade(map);
			if(i==1) {
				ajaxResult.setSuccess(true);
			}
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}

}
