package cn.edu.pdsu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.pdsu.pojo.Grade;

public interface GradeMapper {
	
	//��������꼶
	@Select("SELECT * FROM t_grade ORDER BY create_time DESC")
	public List<Grade> getAllGrade();
	
	//�����꼶
	@Insert("INSERT INTO t_grade VALUES(#{id},#{name},#{create_time})")
	public int insertGrade(Map<String, Object>map);

	//ͨ��idɾ���꼶
	@Delete("DELETE FROM t_grade WHERE id=#{id}")
	public int delGrade(String id);

	//�����꼶��Ϣ
	@Update("UPDATE t_grade SET name=#{name},create_time=#{create_time} WHERE id=#{id}")
	public int updateGrade(Map<String, Object> map);

	//����ʾ��רҵ��Ӧ���꼶��Ϣ
	@Select("SELECT * FROM t_grade " + 
			"INNER JOIN t_classes " + 
			"ON t_classes.grade_id=t_grade.id " + 
			"INNER JOIN t_classes_survey " + 
			"ON t_classes_survey.classes_id=t_classes.id " + 
			"WHERE t_classes_survey.survey_id=#{survey_id} AND t_classes.major_id=#{major_id}" +
			"GROUP BY t_grade.`name`")
	public List<Grade> getGradeBySurveyIdAndMajorId(Map<String, Object> map);

}
