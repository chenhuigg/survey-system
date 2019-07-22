package cn.edu.pdsu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.edu.pdsu.pojo.Classes;
import cn.edu.pdsu.pojo.Grade;

public interface GradeMapper {
	
	//获得所有年级
	@Select("SELECT * FROM t_grade")
	public List<Grade> getAllGrade();

}
