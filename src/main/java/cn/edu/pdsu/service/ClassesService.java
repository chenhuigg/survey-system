package cn.edu.pdsu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.pdsu.mapper.ClassesMapper;
import cn.edu.pdsu.pojo.Classes;

@Service
public class ClassesService {
	@Autowired
	private ClassesMapper classesMapper;
	
	public List<Classes> getClassesByGradeIdAndMajorId(Map<String, String> map){
		return classesMapper.getClassesByGradeIdAndMajorId(map);
	}

}
