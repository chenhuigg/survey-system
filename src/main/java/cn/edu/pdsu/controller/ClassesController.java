package cn.edu.pdsu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.pdsu.aop.ConsumeToken;
import cn.edu.pdsu.aop.ProduceToken;
import cn.edu.pdsu.pojo.AjaxResult;
import cn.edu.pdsu.pojo.Classes;
import cn.edu.pdsu.service.ClassesService;

@RestController
@RequestMapping("/admin")
public class ClassesController {
	@Autowired
	private ClassesService classesService;
	
	/**
	 * 更新班级信息
	 * @param classes
	 * @return
	 */
	@RequestMapping(value="/classes",method=RequestMethod.PUT)
	public Object updateClasses(Classes classes) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			int i= classesService.updateClasses(classes);
			if(i==1) {
				ajaxResult.setSuccess(true);
			}
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	/**
	 * 删除班级
	 * @param id:班级ID
	 * @return
	 */
	@RequestMapping(value="/classes",method=RequestMethod.DELETE)
	public Object delClasses(String id) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			//删除班级
			int i=classesService.delClassesById(id);
			if(i==1) {
				ajaxResult.setSuccess(true);
			}
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	//新增班级
	@ConsumeToken
	@RequestMapping(value="/classes",method=RequestMethod.POST)
	public Object addClasses(String major_id,String grade_id,String name) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			String id=UUID.randomUUID().toString();
			String create_time=new Date().getTime()+"";
			Map<String, Object>map=new HashMap<>();
			map.put("id", id);
			map.put("name", name);
			map.put("grade_id", grade_id);
			map.put("major_id", major_id);
			map.put("create_time", create_time);
			int i = classesService.addClasses(map);
			if(i==1) {
				ajaxResult.setSuccess(true);
			}
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	//查询全部班级信息
	@ProduceToken
	@RequestMapping(value="/classes",method=RequestMethod.GET)
	public Object getClasseses() {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			List<Classes> classeses = classesService.getClasseses();
			ajaxResult.setData(classeses);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	
	//查询班级-问卷信息
	@RequestMapping(value="/classes-wj",method=RequestMethod.GET)
	public Object getClassesByMajorIdAndGradeId(String major,String grade,String id) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			Map<String, String> map=new HashMap<String, String>();
			map.put("major", major);
			map.put("grade",grade);
			map.put("survey_id",id);
			List<Classes> classeses= classesService.getClassesByGradeIdAndMajorId(map);
			ajaxResult.setData(classeses);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	//发布问卷
	@RequestMapping(value="/classes-wj",method=RequestMethod.POST)
	public Object publishWJ(String classes_id,String id) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			Map<String, Object> map=new HashMap<>();
			map.put("classes_id", classes_id);
			map.put("survey_id", id);
			int i=classesService.inSertClassesSurvey(map);
			if(i==1) {
				ajaxResult.setSuccess(true);
			}
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	//删除问卷
	@RequestMapping(value="/classes-wj",method=RequestMethod.DELETE)
	public Object delWJ(String classes_id,String id) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			Map<String, Object> map=new HashMap<>();
			map.put("classes_id", classes_id);
			map.put("survey_id", id);
			int i=classesService.delClassesSurvey(map);
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
