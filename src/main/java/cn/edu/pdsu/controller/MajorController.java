package cn.edu.pdsu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.pdsu.aop.ConsumeToken;
import cn.edu.pdsu.aop.ProduceToken;
import cn.edu.pdsu.pojo.AjaxResult;
import cn.edu.pdsu.pojo.Major;
import cn.edu.pdsu.service.MajorService;

@RestController
@RequestMapping("/admin")
public class MajorController {
	@Autowired
	private MajorService majorService;
	
	//�������רҵ
	@ProduceToken
	@RequestMapping(value="/major",method=RequestMethod.GET)
	public Object getMajors() {
		List<Major> majors = majorService.getAllMajor();
		return AjaxResult.createBySuccessData(majors);
	}
	
	//����רҵ
	@ConsumeToken
	@RequestMapping(value="/major",method=RequestMethod.POST)
	public Object addMajor(String name) {
		String id=UUID.randomUUID().toString();
		String create_time=new Date().getTime()+"";
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", name);
		map.put("id", id);
		map.put("create_time", create_time);
		int i= majorService.addMajor(map);
		if(i==1) {
			return AjaxResult.createBySuccess();
		}
		return AjaxResult.createByErrorMsg("����רҵʧ��");
	}
	
	//ɾ��רҵ
	@RequestMapping(value="/major",method=RequestMethod.DELETE)
	public Object delMajor(String id) {
		int i= majorService.delMajor(id);
		if(i==1) {
			return AjaxResult.createBySuccess();
		}
		return AjaxResult.createByErrorMsg("ɾ��ʧ��");
	}
	
	//����רҵ
	@RequestMapping(value="/major",method=RequestMethod.PUT)
	public Object updateMajor(String id,String name) {
		Map<String, Object> map=new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("create_time",new Date().getTime()+"");
		int i= majorService.updateMajor(map);
		if(i==1) {
			return AjaxResult.createBySuccess();
		}
		return AjaxResult.createByErrorMsg("����רҵʧ��");
	}

}
