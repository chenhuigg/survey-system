package cn.edu.pdsu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.pdsu.aop.ConsumeToken;
import cn.edu.pdsu.aop.ProduceToken;
import cn.edu.pdsu.pojo.AjaxResult;
import cn.edu.pdsu.pojo.Problem;
import cn.edu.pdsu.pojo.Student;
import cn.edu.pdsu.pojo.Survey;
import cn.edu.pdsu.service.AnswerService;
import cn.edu.pdsu.service.ProblemService;
import cn.edu.pdsu.service.SurveyService;

@RestController
public class SurveyController {
	@Autowired
	private SurveyService surveyService;
	@Autowired
	private ProblemService problemService;
	@Autowired
	private AnswerService answerService;
	
	//��ѯ��ǰרҵ���꼶���������ʾ�
	@RequestMapping(value="admin/wj-grade-major",method=RequestMethod.GET)
	public Object getWJByGradeIdAndMajorId(String grade_id,String major_id) {
		Map<String, Object> map=new HashMap<>();
		map.put("grade_id", grade_id);
		map.put("major_id", major_id);
		List<Survey> surveys= surveyService.getSurveyByGradeIdAndMajorId(map);
		return AjaxResult.createBySuccessData(surveys);
	}
	
	
	//����ʾ��б�
	@RequestMapping(value="admin/wj",method=RequestMethod.GET)
	public Object getWJ() {
		//����ʾ��б�
		List<Survey> surveys= surveyService.getAllSurvey();
		return AjaxResult.createBySuccessData(surveys);
	}
	
	//�����ʾ�(��Ҫ����)
	@RequestMapping(value="admin/wj",method=RequestMethod.POST)
	public Object saveWJ(Survey survey,String[] content) {
		//�����ʾ�
		String survey_id=UUID.randomUUID().toString();
		survey.setId(survey_id);
		survey.setCreate_time(new Date().getTime()+"");
		surveyService.saveSurvey(survey);
		//��������
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("survey_id", survey_id);
		map.put("content",content);
		problemService.saveProblem(map);
		return AjaxResult.createBySuccessMsg("�ʾ��ύ�ɹ�");
	}
	
	//ɾ���ʾ�
	@RequestMapping(value="admin/wj",method=RequestMethod.DELETE)
	public Object deleteWJ(String id) {
		int i = surveyService.delSurvey(id);
		if(i==1) {
			return AjaxResult.createBySuccessMsg("ɾ�����ݳɹ�");
		}
		return AjaxResult.createByErrorMsg("ɾ��ʧ��");
	}
	
	//����ʾ��б�ȥ���ѻش�
	@RequestMapping(value="user/my-wj-list",method=RequestMethod.GET)
	public Object getMyWjList(HttpSession session) {
		Student student=(Student) session.getAttribute("student");
		if(student!=null) {
			//���ҵ�ǰѧ��δ��ɵ��ʾ�
			List<Survey> surveys=surveyService.getMyWjList(student);
			return AjaxResult.createBySuccessData(surveys);
		}
		return AjaxResult.createByError();
	}
	
	//����ʾ���ϸ
	@ProduceToken
	@RequestMapping(value="user/wj-detail",method=RequestMethod.GET)
	public Object wjDetail(String id) {
		List<Problem> problems = problemService.getProblemBySurveyId(id);
		return AjaxResult.createBySuccessData(problems);
	}
	
	//�ύ�ʾ�
	@ConsumeToken
	@RequestMapping(value="user/wj-detail",method=RequestMethod.POST)
	public Object submitWJ(Integer[] numbers,@RequestParam("id")String survey_id,HttpSession session) {
		Student student=(Student) session.getAttribute("student");
		if(student!=null&&!student.getId().equals("admin")) {
			//�������id
			List<Problem> problems = problemService.getProblemBySurveyId(survey_id);
			HashMap<String, Object> map=new HashMap<>();
			int score=0;
			for(int i=0;i<numbers.length;i++) {
				if(numbers[i]>100) {
					//�������ܴ���100
					return AjaxResult.createByErrorMsg("�������Ϊ100��");
				}
				problems.get(i).setScore(numbers[i]);
				score+=numbers[i];
			}
			map.put("score", score);
			map.put("survey_id", survey_id);
			map.put("student_id", student.getId());
			map.put("problems", problems);
			int i= answerService.saveAnswer(map);
			answerService.saveAnswerList(map);
			if(i==1) {
				return AjaxResult.createBySuccessMsg("�ύ�ɹ�");
			}
		}
		return AjaxResult.createByErrorMsg("�ʾ��ύʧ��");
	}
	
	//����ʾ����
	@RequestMapping(value="/user/wj-title",method=RequestMethod.GET)
	public Object getWjTitle(String id) {
		//����id��ѯ�ʾ���
		String surveyName= surveyService.getTitleById(id);
		return AjaxResult.createBySuccessData(surveyName);
	}

}
