package cn.edu.pdsu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.pdsu.pojo.Classes;

public interface ClassesMapper {
	
	//新增班级
	@Insert("INSERT INTO t_classes VALUES(#{id},#{name},#{grade_id},#{major_id},#{create_time})")
	public int addClasses(Map<String, Object> map);
	
	//获得班级信息通过gradeId和majorId
	public List<Classes> getClassesByGradeIdAndMajorId(Map<String, String> map);
	
	//获得全部班级信息
	@Select("SELECT * FROM t_classes ORDER BY create_time DESC")
	public List<Classes> getClasseses();

	//新发布问卷
	@Insert("INSERT INTO t_classes_survey VALUES(#{classes_id},#{survey_id},null)")
	public int inSertClassesSurvey(Map<String, Object> map);

	//删除发布的问卷
	@Delete("DELETE FROM t_classes_survey WHERE classes_id=#{classes_id} AND survey_id=#{survey_id}")
	public int delClassesSurvey(Map<String, Object> map);

	//删除班级通过ID
	@Delete("DELETE FROM t_classes WHERE id=#{id}")
	public int delClassesById(String id);

	//更新班级信息
	@Update("UPDATE t_classes SET major_id=#{major.id},grade_id=#{grade.id},name=#{name} WHERE id=#{id}")
	public int updateClasses(Classes classes);
	
}
