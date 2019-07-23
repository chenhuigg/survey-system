package cn.edu.pdsu.controller;

import org.springframework.web.bind.annotation.RequestMapping;

//@Controller//��ǰ����ʧЧ
public class DispatcherController {
	
	//����Ա��¼����
	@RequestMapping("/admin-login")
	public String adminLogin() {
		return "admin-login";
	}
	
	//�û���¼����
	@RequestMapping("/user-login")
	public String userLogin(){
		return "user-login";
	}
	
	//��ҳ
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	//��ҳ
	@RequestMapping("/")
	public String index2() {
		return "index";
	}
	
	//�û��ʾ�����
	@RequestMapping("/my-wj")
	public String myWJ() {
		return "my-wj";
	}
	
	//�û����
	@RequestMapping("/answer-wj")
	public String answerWJ() {
		return "answer-wj";
	}
	
	//����Ա��������
	@RequestMapping("/admin-manager")
	public String adminManager() {
		return "admin-manager";
	}
	
	//�༶����ҳ��
	@RequestMapping("/class-manager")
	public String classManager() {
		return "class-manager";
	}
	
	//�༭�ʾ�
	@RequestMapping("/edit-wj")
	public String editWJ() {
		return "edit-wj";
	}
	
	//�ʾ��б�
	@RequestMapping("/list-wj")
	public String listWJ() {
		return "list-wj";
	}
	
	//רҵ����ҳ��
	@RequestMapping("/major-manager")
	public String majorManager() {
		return "major-manager";
	}
	
	//�����ʾ�
	@RequestMapping("/publish-wj")
	public String publishWJ() {
		return "publish-wj";
	}
	
	//ͬ�첻ͬ��Ŀ
	@RequestMapping("/same-grade")
	public String sameGrade() {
		return "same-grade";
	}
	
	//ͬ��Ŀ��ͬ��
	@RequestMapping("/same-subject")
	public String sameSubject() {
		return "same-subject";
	}
	
	
}
