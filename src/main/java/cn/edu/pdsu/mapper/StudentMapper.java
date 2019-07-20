package cn.edu.pdsu.mapper;

import org.apache.ibatis.annotations.Select;

import cn.edu.pdsu.pojo.Student;

public interface StudentMapper {
	
	@Select("SELECT * FROM t_student WHERE no=#{no} AND password=#{password}")
	public Student getStudentByNoAndPassword(Student student);

}
