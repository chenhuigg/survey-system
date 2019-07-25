package cn.edu.pdsu.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.pdsu.mapper.AnswerMapper;

@Service
public class AnswerService {
	@Autowired
	private AnswerMapper answerMapper;
	
	public int saveAnswer(HashMap<String, Object> map) {
		return answerMapper.saveAnswer(map);
	}
	

}
