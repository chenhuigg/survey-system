package cn.edu.pdsu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.edu.pdsu.pojo.Major;

public interface MajorMapper {
	
	//��������רҵ
	@Select("SELECT * FROM t_major")
	public List<Major> getAllMajor();

}
