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
	
	//查询当前专业和年级所发布的问卷
	@RequestMapping(value="admin/wj-grade-major",method=RequestMethod.GET)
	public Object getWJByGradeIdAndMajorId(String grade_id,String major_id) {
		Map<String, Object> map=new HashMap<>();
		map.put("grade_id", grade_id);
		map.put("major_id", major_id);
		List<Survey> surveys= surveyService.getSurveyByGradeIdAndMajorId(map);
		return AjaxResult.createBySuccessData(surveys);
	}
	
	
	//获得问卷列表
	@RequestMapping(value="admin/wj",method=RequestMethod.GET)
	public Object getWJ() {
		//获得问卷列表
		List<Survey> surveys= surveyService.getAllSurvey();
		return AjaxResult.createBySuccessData(surveys);
	}
	
	//增加问卷(需要事务)
	@RequestMapping(value="admin/wj",method=RequestMethod.POST)
	public Object saveWJ(Survey survey,String[] content) {
		//增加问卷
		String survey_id=UUID.randomUUID().toString();
		survey.setId(survey_id);
		survey.setCreate_time(new Date().getTime()+"");
		surveyService.saveSurvey(survey);
		//增加问题
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("survey_id", survey_id);
		map.put("content",content);
		problemService.saveProblem(map);
		return AjaxResult.createBySuccessMsg("问卷提交成功");
	}
	
	//删除问卷
	@RequestMapping(value="admin/wj",method=RequestMethod.DELETE)
	public Object deleteWJ(String id) {
		int i = surveyService.delSurvey(id);
		if(i==1) {
			return AjaxResult.createBySuccessMsg("删除数据成功");
		}
		return AjaxResult.createByErrorMsg("删除失败");
	}
	
	//获得问卷列表（去掉已回答）
	@RequestMapping(value="user/my-wj-list",method=RequestMethod.GET)
	public Object getMyWjList(HttpSession session) {
		Student student=(Student) session.getAttribute("student");
		if(student!=null) {
			//查找当前学生未完成的问卷
			List<Survey> surveys=surveyService.getMyWjList(student);
			return AjaxResult.createBySuccessData(surveys);
		}
		return AjaxResult.createByError();
	}
	
	//获得问卷详细
	@ProduceToken
	@RequestMapping(value="user/wj-detail",method=RequestMethod.GET)
	public Object wjDetail(String id) {
		List<Problem> problems = problemService.getProblemBySurveyId(id);
		return AjaxResult.createBySuccessData(problems);
	}
	
	//提交问卷
	@ConsumeToken
	@RequestMapping(value="user/wj-detail",method=RequestMethod.POST)
	public Object submitWJ(Integer[] numbers,@RequestParam("id")String survey_id,HttpSession session) {
		Student student=(Student) session.getAttribute("student");
		if(student!=null&&!student.getId().equals("admin")) {
			//获得问题id
			List<Problem> problems = problemService.getProblemBySurveyId(survey_id);
			HashMap<String, Object> map=new HashMap<>();
			int score=0;
			for(int i=0;i<numbers.length;i++) {
				if(numbers[i]>100) {
					//分数不能大于100
					return AjaxResult.createByErrorMsg("分数最大为100分");
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
				return AjaxResult.createBySuccessMsg("提交成功");
			}
		}
		return AjaxResult.createByErrorMsg("问卷提交失败");
	}
	
	//获得问卷标题
	@RequestMapping(value="/user/wj-title",method=RequestMethod.GET)
	public Object getWjTitle(String id) {
		//根据id查询问卷名
		String surveyName= surveyService.getTitleById(id);
		return AjaxResult.createBySuccessData(surveyName);
	}

}
