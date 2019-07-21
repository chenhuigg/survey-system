package cn.edu.pdsu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import cn.edu.pdsu.pojo.Problem;

public interface ProblemMapper {
	
	//��ȡ�ʾ�����
	@Select("SELECT * FROM t_problem WHERE survey_id=#{survey_id} ORDER BY sort ASC")
	public List<Problem> getProblemBySurveyId(String survey_id);

	//��������
	public void saveProblem(Map<String, Object> map);

}
