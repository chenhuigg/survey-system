package cn.edu.pdsu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.pdsu.mapper.SurveyMapper;
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

}
