package cn.edu.pdsu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.edu.pdsu.pojo.Student;
import cn.edu.pdsu.pojo.Survey;

public interface SurveyMapper {
	
	//查询问卷
	@Select("SELECT * FROM t_survey ORDER BY create_time DESC")
	public List<Survey> getAllSurvey();

	//新增问卷
	@Insert("INSERT INTO t_survey VALUES(#{id},#{name},null,null,#{version},#{create_time} )")
	public void saveSurvey(Survey survey);

	//删除问卷
	@Delete("DELETE FROM t_survey WHERE id=#{id}")
	public int delSurvey(String id);

	//查找当前学生未完成的问卷
	@Select("SELECT *,cs.expires_time expires_time FROM t_survey su " + 
			"INNER JOIN t_classes_survey cs " + 
			"ON su.id=cs.survey_id " + 
			"WHERE (SELECT COUNT(1) FROM t_answer a WHERE cs.survey_id=a.survey_id AND a.student_id=#{id})=0 "+
			"AND cs.classes_id=#{classes.id}")
	public List<Survey> getSurveyNotFinish(Student student);

	//查询当前专业和年级所发布的问卷
	@Select("SELECT * FROM t_survey " + 
			"INNER JOIN t_classes_survey " + 
			"ON t_survey.id=t_classes_survey.survey_id " + 
			"INNER JOIN t_classes " + 
			"ON t_classes.id=t_classes_survey.classes_id " + 
			"WHERE grade_id=#{grade_id} AND major_id=#{major_id} "+
	 		"GROUP BY t_survey.`name`")
	public List<Survey> getSurveyByGradeIdAndMajorId(Map<String, Object>map);

	@Select("SELECT name FROM t_survey WHERE id=#{id}")
	public String getTitleById(String id);
	

}
