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
	 * ���°༶��Ϣ
	 * @param classes
	 * @return
	 */
	@RequestMapping(value="/classes",method=RequestMethod.PUT)
	public Object updateClasses(Classes classes) {
		int i= classesService.updateClasses(classes);
		if(i==1) {
			return AjaxResult.createBySuccess();
		}
		return AjaxResult.createByErrorMsg("���°༶��Ϣʧ��");
	}
	
	/**
	 * ɾ���༶
	 * @param id:�༶ID
	 * @return
	 */
	@RequestMapping(value="/classes",method=RequestMethod.DELETE)
	public Object delClasses(String id) {
		//ɾ���༶
		int i=classesService.delClassesById(id);
		if(i==1) {
			return AjaxResult.createBySuccess();
		}
		return AjaxResult.createByErrorMsg("ɾ���༶��Ϣʧ��");
	}
	
	//�����༶
	@ConsumeToken
	@RequestMapping(value="/classes",method=RequestMethod.POST)
	public Object addClasses(String major_id,String grade_id,String name) {
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
			return AjaxResult.createBySuccess();
		}
		return AjaxResult.createByErrorMsg("�����༶ʧ��");
	}
	
	//��ѯȫ���༶��Ϣ
	@ProduceToken
	@RequestMapping(value="/classes",method=RequestMethod.GET)
	public Object getClasseses() {
		List<Classes> classeses = classesService.getClasseses();
		return AjaxResult.createBySuccessData(classeses);
	}
	
	
	//��ѯ�༶-�ʾ���Ϣ
	@ProduceToken
	@RequestMapping(value="/classes-wj",method=RequestMethod.GET)
	public Object getClassesByMajorIdAndGradeId(String major,String grade,String id) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("major", major);
		map.put("grade",grade);
		map.put("survey_id",id);
		List<Classes> classeses= classesService.getClassesByGradeIdAndMajorId(map);
		return AjaxResult.createBySuccessData(classeses);
	}
	
	//�����ʾ�
	@RequestMapping(value="/classes-wj",method=RequestMethod.POST)
	public Object publishWJ(String classes_id,String id) {
		Map<String, Object> map=new HashMap<>();
		map.put("classes_id", classes_id);
		map.put("survey_id", id);
		int i=classesService.inSertClassesSurvey(map);
		if(i==1) {
			return AjaxResult.createBySuccess();
		}
		return AjaxResult.createByErrorMsg("�����ʾ�ʧ��");
	}
	
	//ɾ���ʾ�
	@RequestMapping(value="/classes-wj",method=RequestMethod.DELETE)
	public Object delWJ(String classes_id,String id) {
		Map<String, Object> map=new HashMap<>();
		map.put("classes_id", classes_id);
		map.put("survey_id", id);
		int i=classesService.delClassesSurvey(map);
		if(i==1) {
			return AjaxResult.createBySuccess();
		}
		return AjaxResult.createByErrorMsg("ɾ���ʾ�ʧ��");
	}
	

}
