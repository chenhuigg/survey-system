package cn.edu.pdsu.service;

import java.util.List;

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

}
