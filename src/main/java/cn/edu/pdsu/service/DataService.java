package cn.edu.pdsu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.pdsu.mapper.DataMapper;
import cn.edu.pdsu.pojo.Data;

@Service
public class DataService {
	@Autowired
	private DataMapper dataMapper;
	
	public List<Data> getDataByMajorIdAndGradeId(Map<String, Object> map) {
		return dataMapper.getDataByMajorIdAndGradeId(map);
	}
	

}
