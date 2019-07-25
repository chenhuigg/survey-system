package cn.edu.pdsu.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.pdsu.pojo.AjaxResult;

@RestController
@RequestMapping("/admin")
public class DataController {
	
	//同届不同科目
	@RequestMapping("/get-same-grade")
	public Object sameGrade(String major_id,String grade_id,String[] surveys) {
		AjaxResult ajaxResult=new AjaxResult();
		try {
			System.out.println(major_id);
			System.out.println(grade_id);
			System.out.println(Arrays.toString(surveys));
			//获取数据---问卷名称、分数总数量、分数段的数量
			
			
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			ajaxResult.setSuccess(false);
			e.printStackTrace();
		}
		return ajaxResult;
	}

}
