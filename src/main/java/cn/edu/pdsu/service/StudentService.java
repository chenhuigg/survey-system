package cn.edu.pdsu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.pdsu.mapper.StudentMapper;
import cn.edu.pdsu.pojo.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentMapper studentMapper;
	
	public Student userLogin(Student student) {
		return studentMapper.getStudentByNoAndPassword(student);
	}

}
