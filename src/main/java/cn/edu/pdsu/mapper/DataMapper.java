package cn.edu.pdsu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import cn.edu.pdsu.pojo.Data;

public interface DataMapper {
	
	@Select("SELECT num,COUNT(num) count,name FROM ( " + 
			"	SELECT FLOOR(score/100) as num,t_survey.`name` as name FROM t_answer " + 
			"	INNER JOIN t_student " + 
			"	ON t_answer.student_id=t_student.id " + 
			"	INNER JOIN t_classes " + 
			"	ON t_classes.id=t_student.classes_id "+
			"   INNER JOIN t_survey " + 
			"   ON t_answer.survey_id=t_survey.id " + 
			"	WHERE t_classes.major_id=#{major_id} AND t_classes.grade_id=#{grade_id} AND t_answer.survey_id=#{survey_id} " + 
			") answer " + 
			"GROUP BY num")
	public List<Data> getDataByMajorIdAndGradeId(Map<String, Object> map);

	@Select("SELECT num,COUNT(num) count,name FROM ( " + 
			"SELECT FLOOR(score/100) as num,t_grade.`name` as name FROM t_answer " + 
			"INNER JOIN t_student " + 
			"ON t_answer.student_id=t_student.id " + 
			"INNER JOIN t_classes " + 
			"ON t_classes.id=t_student.classes_id " + 
			"INNER JOIN t_grade " + 
			"ON t_grade.id=t_classes.grade_id " + 
			"WHERE t_classes.major_id=#{major_id} AND t_classes.grade_id=#{grade_id} AND t_answer.survey_id=#{survey_id} " + 
			") answer " + 
			"GROUP BY num " )
	public List<Data> getDataByMajorIdAndSurveyId(Map<String, Object> map);
	
	@Select("SELECT sum(score) FROM t_problem WHERE survey_id=#{survey_id}")
	public int getSumScore(String survey_id);

}
