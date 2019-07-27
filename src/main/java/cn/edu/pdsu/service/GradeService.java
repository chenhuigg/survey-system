package cn.edu.pdsu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.pdsu.mapper.GradeMapper;
import cn.edu.pdsu.pojo.Grade;

@Service
public class GradeService {
	
	@Autowired
	private GradeMapper gradeMapper;
	
	public List<Grade> getAllGrade(){
		return gradeMapper.getAllGrade();
	}
	
	public int addGrade(Map<String, Object> map) {
		return gradeMapper.insertGrade(map);
	}

	public int delGrade(String id) {
		return gradeMapper.delGrade(id);
	}

	public int updateGrade(Map<String, Object> map) {
		return gradeMapper.updateGrade(map);
	}

	public List<Grade> getGradeBySurveyIdAndMajorId(Map<String, Object> map) {
		return gradeMapper.getGradeBySurveyIdAndMajorId(map);
	}

}
