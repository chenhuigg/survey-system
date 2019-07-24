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
	
	//查询所有班级信息
	public List<Classes> getClasseses(){
		return classesMapper.getClasseses();
	}
	
	//查询班级信息
	public List<Classes> getClassesByGradeIdAndMajorId(Map<String, String> map){
		return classesMapper.getClassesByGradeIdAndMajorId(map);
	}

	//发布问卷
	public int inSertClassesSurvey(Map<String, Object> map) {
		return classesMapper.inSertClassesSurvey(map);
	}

	public int delClassesSurvey(Map<String, Object> map) {
		return classesMapper.delClassesSurvey(map);
	}

	//新增班级
	public int addClasses(Map<String, Object> map) {
		return classesMapper.addClasses(map);
	}

	public int delClassesById(String id) {
		return classesMapper.delClassesById(id);
	}

	//更新班级信息
	public int updateClasses(Classes classes) {
		return classesMapper.updateClasses(classes);
	}
	
	//查询班级的问卷发布信息
	/*public List<Classes_Survey> getAllClassesSurvey(String survey_id){
		return classesMapper.getAllClassesSurvey(survey_id);
	}*/

}
