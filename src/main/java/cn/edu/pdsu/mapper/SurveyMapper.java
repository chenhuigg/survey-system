package cn.edu.pdsu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.edu.pdsu.pojo.Survey;

public interface SurveyMapper {
	
	//查询问卷
	@Select("SELECT * FROM t_survey ORDER BY create_time DESC")
	public List<Survey> getAllSurvey();

	//新增问卷
	@Insert("Insert INTO t_survey VALUES(#{id},#{name},null,null,#{version},#{create_time} )")
	public void saveSurvey(Survey survey);

}
