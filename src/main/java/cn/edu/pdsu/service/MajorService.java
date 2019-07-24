package cn.edu.pdsu.service;

import java.util.List;
import java.util.Map;

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

	public int addMajor(Map<String, Object> map) {
		return majorMapper.insertMajor(map);
	}

	public int delMajor(String id) {
		return majorMapper.delMajor(id);
	}

	public int updateMajor(Map<String, Object> map) {
		return majorMapper.updateMajor(map);
	}

}
