package cn.edu.pdsu.mapper;

import java.util.List;
import java.util.Map;

import cn.edu.pdsu.pojo.Classes;

public interface ClassesMapper {
	
	//��ð༶��Ϣͨ��gradeId��majorId
	public List<Classes> getClassesByGradeIdAndMajorId(Map<String, String> map);

}
