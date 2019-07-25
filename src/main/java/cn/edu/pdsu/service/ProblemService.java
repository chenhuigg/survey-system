package cn.edu.pdsu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.pdsu.mapper.ProblemMapper;
import cn.edu.pdsu.pojo.Problem;

@Service
public class ProblemService {
	
	@Autowired
	private ProblemMapper problemMapper;
	
	public List<Problem> getProblemBySurveyId(String survey_id){
		return problemMapper.getProblemBySurveyId(survey_id);
	}

	public void saveProblem(Map<String, Object> map) {
		problemMapper.saveProblem(map);
	}

}
