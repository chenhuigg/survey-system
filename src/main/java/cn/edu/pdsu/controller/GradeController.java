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
import cn.edu.pdsu.pojo.Grade;
import cn.edu.pdsu.service.GradeService;

@RestController
@RequestMapping("/admin")
public class GradeController {
	@Autowired
	private GradeService gradeService;
	
	//רҵ�Ϳ�Ŀ��������������������꼶
	@RequestMapping(value="/grade-major-survey",method=RequestMethod.GET)
	public Object getWjByMajorIdAndGradeId(String major_id,String survey_id) {
		Map<String, Object> map=new HashMap<>();
		map.put("survey_id", survey_id);
		map.put("major_id", major_id);
		List<Grade> grades= gradeService.getGradeBySurveyIdAndMajorId(map);
		return AjaxResult.createBySuccessData(grades);
	}
	
	//��ȡȫ���꼶
	@ProduceToken
	@RequestMapping(value="/grade",method=RequestMethod.GET)
	public Object getAllGrade() {
		List<Grade> grades = gradeService.getAllGrade();
		return AjaxResult.createBySuccessData(grades);
	}
	
	//�����꼶
	@ConsumeToken
	@RequestMapping(value="/grade",method=RequestMethod.POST)
	public Object addMajor(String name) {
		String id=UUID.randomUUID().toString();
		String create_time=new Date().getTime()+"";
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", name);
		map.put("id", id);
		map.put("create_time", create_time);
		int i= gradeService.addGrade(map);
		if(i==1) {
			return AjaxResult.createBySuccess();
		}
		return AjaxResult.createByErrorMsg("�����꼶ʧ��");
	}
	
	//ɾ���꼶
	@RequestMapping(value="/grade",method=RequestMethod.DELETE)
	public Object delMajor(String id) {
		int i= gradeService.delGrade(id);
		if(i==1) {
			return AjaxResult.createBySuccess();
		}
		return AjaxResult.createByErrorMsg("ɾ��ʧ��");
	}
	
	//�����꼶
	@RequestMapping(value="/grade",method=RequestMethod.PUT)
	public Object updateMajor(String id,String name) {
		Map<String, Object> map=new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("create_time", new Date().getTime()+"");
		int i= gradeService.updateGrade(map);
		if(i==1) {
			return AjaxResult.createBySuccess();
		}
		return AjaxResult.createByErrorMsg("�����꼶ʧ��");
	}

}
