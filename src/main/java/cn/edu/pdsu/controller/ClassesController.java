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
	
	//��ѯ�༶-�ʾ���Ϣ
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
	
	//�����ʾ�
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
	
	//ɾ���ʾ�
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
