package cn.edu.pdsu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.edu.pdsu.pojo.Survey;

public interface SurveyMapper {
	
	//��ѯ�ʾ�
	@Select("SELECT * FROM t_survey ORDER BY create_time DESC")
	public List<Survey> getAllSurvey();

	//�����ʾ�
	@Insert("INSERT INTO t_survey VALUES(#{id},#{name},null,null,#{version},#{create_time} )")
	public void saveSurvey(Survey survey);

	//ɾ���ʾ�
	@Delete("DELETE FROM t_survey WHERE id=#{id}")
	public int delSurvey(String id);

}
