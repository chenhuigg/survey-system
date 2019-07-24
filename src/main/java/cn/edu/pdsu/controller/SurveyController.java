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
import cn.edu.pdsu.pojo.Problem;
import cn.edu.pdsu.pojo.Survey;
import cn.edu.pdsu.service.ProblemService;
import cn.edu.pdsu.service.SurveyService;

@RestController
public class SurveyController {
	@Autowired
	private SurveyService surveyService;
	@Autowired
	private ProblemService problemService;
	
	//����ʾ��б�
	@RequestMapping(value="admin/wj",method=RequestMethod.GET)
	public Object getWJ() {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			//����ʾ��б�
			List<Survey> surveys= surveyService.getAllSurvey();
			ajaxResult.setSuccess(true);
			ajaxResult.setData(surveys);
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	//�����ʾ�(��Ҫ����)
	@RequestMapping(value="admin/wj",method=RequestMethod.POST)
	public Object saveWJ(Survey survey,String[] content) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			//�����ʾ�
			String survey_id=UUID.randomUUID().toString();
			survey.setId(survey_id);
			survey.setCreate_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			surveyService.saveSurvey(survey);
			//��������
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("survey_id", survey_id);
			map.put("content",content);
			problemService.saveProblem(map);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	//ɾ���ʾ�
	@RequestMapping(value="admin/wj",method=RequestMethod.DELETE)
	public Object deleteWJ(String id) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			int i = surveyService.delSurvey(id);
			if(i==1) {
				ajaxResult.setSuccess(true);
			}
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	//����ʾ��б�
	@RequestMapping(value="user/my-wj-list",method=RequestMethod.GET)
	public Object getMyWjList() {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			
			
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	//����ʾ���ϸ
	@RequestMapping(value="user/wj-detail",method=RequestMethod.GET)
	public Object wjDetail(String id) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			List<Problem> problems = problemService.getProblemBySurveyId(id);
			ajaxResult.setSuccess(true);
			ajaxResult.setData(problems);
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}

}
