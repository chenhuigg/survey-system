package cn.edu.pdsu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import cn.edu.pdsu.pojo.Classes;

public interface ClassesMapper {
	
	//��ð༶��Ϣͨ��gradeId��majorId
	public List<Classes> getClassesByGradeIdAndMajorId(Map<String, String> map);

	//�·����ʾ�
	@Insert("INSERT INTO t_classes_survey VALUES(#{classes_id},#{survey_id},null)")
	public int inSertClassesSurvey(Map<String, Object> map);

	//ɾ���������ʾ�
	@Delete("DELETE FROM t_classes_survey WHERE classes_id=#{classes_id} AND survey_id=#{survey_id}")
	public int delClassesSurvey(Map<String, Object> map);

	//ͨ���ʾ�id��ð༶-�ʾ���Ϣ�������ж��Ƿ��ѷ�����
	//@Select("SELECT * FROM t_classes_survey WHERE survey_id=#{survey_id}")
	//public List<Classes_Survey> getAllClassesSurvey(String survey_id);
	
	

}
