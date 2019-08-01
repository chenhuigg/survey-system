package cn.edu.pdsu.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Insert;

public interface AnswerMapper {

	@Insert("INSERT INTO t_answer VALUES (#{survey_id},#{student_id},#{score})")
	int saveAnswer(HashMap<String, Object> map);

	int saveAnswerList(HashMap<String, Object> map);
	
}
