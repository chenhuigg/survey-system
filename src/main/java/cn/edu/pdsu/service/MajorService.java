package cn.edu.pdsu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.pdsu.mapper.MajorMapper;
import cn.edu.pdsu.pojo.Major;

@Service
public class MajorService {
	@Autowired
	private MajorMapper majorMapper;
	
	public List<Major> getAllMajor(){
		return majorMapper.getAllMajor();
	}

}
