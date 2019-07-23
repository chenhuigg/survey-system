package cn.edu.pdsu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import cn.edu.pdsu.pojo.Classes;

public interface ClassesMapper {
	
	//获得班级信息通过gradeId和majorId
	public List<Classes> getClassesByGradeIdAndMajorId(Map<String, String> map);

	//新发布问卷
	@Insert("INSERT INTO t_classes_survey VALUES(#{classes_id},#{survey_id},null)")
	public int inSertClassesSurvey(Map<String, Object> map);

	//删除发布的问卷
	@Delete("DELETE FROM t_classes_survey WHERE classes_id=#{classes_id} AND survey_id=#{survey_id}")
	public int delClassesSurvey(Map<String, Object> map);

	//通过问卷id获得班级-问卷信息（用于判断是否已发布）
	//@Select("SELECT * FROM t_classes_survey WHERE survey_id=#{survey_id}")
	//public List<Classes_Survey> getAllClassesSurvey(String survey_id);
	
	

}
