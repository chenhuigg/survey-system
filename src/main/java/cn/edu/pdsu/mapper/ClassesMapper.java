package cn.edu.pdsu.mapper;

import java.util.List;
import java.util.Map;

import cn.edu.pdsu.pojo.Classes;

public interface ClassesMapper {
	
	//获得班级信息通过gradeId和majorId
	public List<Classes> getClassesByGradeIdAndMajorId(Map<String, String> map);

}
