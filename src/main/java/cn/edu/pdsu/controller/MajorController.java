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

import cn.edu.pdsu.pojo.AjaxResult;
import cn.edu.pdsu.pojo.Major;
import cn.edu.pdsu.service.MajorService;

@RestController
@RequestMapping("/admin")
public class MajorController {
	@Autowired
	private MajorService majorService;
	
	//获得所有专业
	@RequestMapping(value="/major",method=RequestMethod.GET)
	public Object getMajors() {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			List<Major> majors = majorService.getAllMajor();
			ajaxResult.setData(majors);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	//新增专业
	@RequestMapping(value="/major",method=RequestMethod.POST)
	public Object addMajor(String name) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			String id=UUID.randomUUID().toString();
			String create_time=new Date().getTime()+"";
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("name", name);
			map.put("id", id);
			map.put("create_time", create_time);
			int i= majorService.addMajor(map);
			if(i==1) {
				ajaxResult.setSuccess(true);
			}
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	//删除专业
	@RequestMapping(value="/major",method=RequestMethod.DELETE)
	public Object delMajor(String id) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			int i= majorService.delMajor(id);
			if(i==1) {
				ajaxResult.setSuccess(true);
			}
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}
	
	//更新专业
	@RequestMapping(value="/major",method=RequestMethod.PUT)
	public Object updateMajor(String id,String name) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			Map<String, Object> map=new HashMap<>();
			map.put("id", id);
			map.put("name", name);
			map.put("create_time",new Date().getTime()+"");
			int i= majorService.updateMajor(map);
			if(i==1) {
				ajaxResult.setSuccess(true);
			}
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}

}
