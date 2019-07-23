package cn.edu.pdsu.controller;

import org.springframework.web.bind.annotation.RequestMapping;

//@Controller//当前类已失效
public class DispatcherController {
	
	//管理员登录界面
	@RequestMapping("/admin-login")
	public String adminLogin() {
		return "admin-login";
	}
	
	//用户登录界面
	@RequestMapping("/user-login")
	public String userLogin(){
		return "user-login";
	}
	
	//首页
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	//首页
	@RequestMapping("/")
	public String index2() {
		return "index";
	}
	
	//用户问卷中心
	@RequestMapping("/my-wj")
	public String myWJ() {
		return "my-wj";
	}
	
	//用户答卷
	@RequestMapping("/answer-wj")
	public String answerWJ() {
		return "answer-wj";
	}
	
	//管理员管理中心
	@RequestMapping("/admin-manager")
	public String adminManager() {
		return "admin-manager";
	}
	
	//班级管理页面
	@RequestMapping("/class-manager")
	public String classManager() {
		return "class-manager";
	}
	
	//编辑问卷
	@RequestMapping("/edit-wj")
	public String editWJ() {
		return "edit-wj";
	}
	
	//问卷列表
	@RequestMapping("/list-wj")
	public String listWJ() {
		return "list-wj";
	}
	
	//专业管理页面
	@RequestMapping("/major-manager")
	public String majorManager() {
		return "major-manager";
	}
	
	//发布问卷
	@RequestMapping("/publish-wj")
	public String publishWJ() {
		return "publish-wj";
	}
	
	//同届不同科目
	@RequestMapping("/same-grade")
	public String sameGrade() {
		return "same-grade";
	}
	
	//同科目不同届
	@RequestMapping("/same-subject")
	public String sameSubject() {
		return "same-subject";
	}
	
	
}
