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
		//保存问卷
		return answerMapper.saveAnswer(map);
	}
	
	public int saveAnswerList(HashMap<String, Object> map) {
		//保存分数信息
		return answerMapper.saveAnswerList(map);
	}

}
