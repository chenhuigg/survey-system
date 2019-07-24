package cn.edu.pdsu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.pdsu.pojo.Major;

public interface MajorMapper {
	
	//查找所有专业
	@Select("SELECT * FROM t_major ORDER BY create_time DESC")
	public List<Major> getAllMajor();

	//新增专业
	@Insert("INSERT INTO t_major VALUES(#{id},#{name},#{create_time})")
	public int insertMajor(Map<String, Object>map);

	//通过id删除专业
	@Delete("DELETE FROM t_major WHERE id=#{id}")
	public int delMajor(String id);

	//更新专业信息
	@Update("UPDATE t_major SET name=#{name},create_time=#{create_time} WHERE id=#{id}")
	public int updateMajor(Map<String, Object> map);
	
	

}
