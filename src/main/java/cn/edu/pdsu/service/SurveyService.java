package cn.edu.pdsu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.pdsu.mapper.SurveyMapper;
import cn.edu.pdsu.pojo.Student;
import cn.edu.pdsu.pojo.Survey;

@Service
public class SurveyService {
	@Autowired
	private SurveyMapper surveyMapper;
	
	public List<Survey> getAllSurvey(){
		return surveyMapper.getAllSurvey();
	}

	public void saveSurvey(Survey survey) {
		surveyMapper.saveSurvey(survey);
	}

	public int delSurvey(String id) {
		return surveyMapper.delSurvey(id);
	}

	//查找当前学生未完成的问卷
	public List<Survey> getMyWjList(Student student) {
		return surveyMapper.getSurveyNotFinish(student);
	}

	public List<Survey> getSurveyByGradeIdAndMajorId(Map<String, Object> map) {
		return surveyMapper.getSurveyByGradeIdAndMajorId(map);
	}

	public String getTitleById(String id) {
		return surveyMapper.getTitleById(id);
	}

}
