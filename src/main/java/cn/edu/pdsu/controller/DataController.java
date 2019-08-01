package cn.edu.pdsu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.pdsu.pojo.AjaxResult;
import cn.edu.pdsu.pojo.Data;
import cn.edu.pdsu.service.DataService;

@RestController
@RequestMapping("/admin")
public class DataController {
	@Autowired
	private DataService dataservice;
	
	//ͬ�첻ͬ��Ŀ
	@RequestMapping("/get-same-grade")
	public Object sameGrade(String major_id,String grade_id,String[] surveys) {
		//��ȡ����---�ʾ����ơ������������������ε�����
		if(surveys!=null) {
			Map<String, Object> resultmap=new HashMap<>();
			int sum=0;
			for (String survey_id : surveys) {
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("major_id", major_id);
				map.put("grade_id", grade_id);
				map.put("survey_id",survey_id);
				//���ҵ�ǰ�ʾ�����
				List<Data> datas=dataservice.getDataByMajorIdAndGradeId(map);
				//����ʾ��Ӧ�����������ܷ֣�ÿ��100�֣�
				int tempSum= dataservice.getSumScore(survey_id);
				if(tempSum>sum) {
					sum=tempSum;
				}
				resultmap.put(survey_id, datas);
				resultmap.put("sum", sum);
			}
			return AjaxResult.createBySuccessData(resultmap);
		}
		return AjaxResult.createByErrorMsg("���ݲ�ѯʧ��");
	}
	
	//ͬ��Ŀ��ͬ��
	@RequestMapping("/get-same-subject")
	public Object sameSubject(String major_id,String survey_id,String[] grades) {
		//��ȡ����---�ʾ����ơ������������������ε�����
		if(grades!=null) {
			Map<String, Object> resultmap=new HashMap<>();
			for (String grade_id : grades) {
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("major_id", major_id);
				map.put("grade_id", grade_id);
				map.put("survey_id",survey_id);
				List<Data> datas=dataservice.getDataByMajorIdAndSurveyId(map);
				resultmap.put(grade_id, datas);
			}
			int sum= dataservice.getSumScore(survey_id);
			resultmap.put("sum", sum);
			return AjaxResult.createBySuccessData(resultmap);
		}
		return AjaxResult.createByError();
	}

}
