package cn.edu.pdsu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.pdsu.pojo.Major;

public interface MajorMapper {
	
	//��������רҵ
	@Select("SELECT * FROM t_major ORDER BY create_time DESC")
	public List<Major> getAllMajor();

	//����רҵ
	@Insert("INSERT INTO t_major VALUES(#{id},#{name},#{create_time})")
	public int insertMajor(Map<String, Object>map);

	//ͨ��idɾ��רҵ
	@Delete("DELETE FROM t_major WHERE id=#{id}")
	public int delMajor(String id);

	//����רҵ��Ϣ
	@Update("UPDATE t_major SET name=#{name},create_time=#{create_time} WHERE id=#{id}")
	public int updateMajor(Map<String, Object> map);
	
	

}
