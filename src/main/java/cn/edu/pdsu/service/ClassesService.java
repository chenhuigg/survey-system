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
	
	//��ѯ���а༶��Ϣ
	public List<Classes> getClasseses(){
		return classesMapper.getClasseses();
	}
	
	//��ѯ�༶��Ϣ
	public List<Classes> getClassesByGradeIdAndMajorId(Map<String, String> map){
		return classesMapper.getClassesByGradeIdAndMajorId(map);
	}

	//�����ʾ�
	public int inSertClassesSurvey(Map<String, Object> map) {
		return classesMapper.inSertClassesSurvey(map);
	}

	public int delClassesSurvey(Map<String, Object> map) {
		return classesMapper.delClassesSurvey(map);
	}

	//�����༶
	public int addClasses(Map<String, Object> map) {
		return classesMapper.addClasses(map);
	}

	public int delClassesById(String id) {
		return classesMapper.delClassesById(id);
	}

	//���°༶��Ϣ
	public int updateClasses(Classes classes) {
		return classesMapper.updateClasses(classes);
	}
	
	//��ѯ�༶���ʾ�����Ϣ
	/*public List<Classes_Survey> getAllClassesSurvey(String survey_id){
		return classesMapper.getAllClassesSurvey(survey_id);
	}*/

}
