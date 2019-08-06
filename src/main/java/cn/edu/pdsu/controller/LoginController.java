package cn.edu.pdsu.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.pdsu.pojo.Admin;
import cn.edu.pdsu.pojo.AjaxResult;
import cn.edu.pdsu.pojo.Classes;
import cn.edu.pdsu.pojo.Student;
import cn.edu.pdsu.service.AdminService;
import cn.edu.pdsu.service.StudentService;

@Controller
public class LoginController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private AdminService adminService;
	//����Ա��¼
	@ResponseBody
	@RequestMapping(value="/a-login",method=RequestMethod.POST)
	public Object adminLogin(Admin admin,String code,HttpSession session) {
		//�ж���֤���Ƿ���ȷ����ȷ������֤������
		String sessionCode =  (String) session.getAttribute("Code");
		//��֤�벻��ȷ
		if(sessionCode==null||code==null||
				sessionCode==""||code==""||!sessionCode.equals(code)) {
			return AjaxResult.createByErrorMsg("��֤�����");
		}
		session.setAttribute("Code",null);
		//��ѯ�û���Ϣ��ͨ���û���������
		admin=adminService.userLogin(admin);
		if(admin!=null) {
			//���û���Ϣ����Session
			session.setAttribute("admin", admin);
			//����ѧ����Ϣ����ֹ��������Session
			Student student=new Student();
			student.setId("admin");
			student.setName("����Ա");
			Classes classes=new Classes();
			classes.setId("admin");
			student.setClasses(classes);
			session.setAttribute("student", student);
			return AjaxResult.createBySuccess();
		}
		return AjaxResult.createByErrorMsg("�û������������");
	}
	
	//����û���¼״̬
	@ResponseBody
	@RequestMapping("/islogin")
	public Object isLogin(HttpSession session) {
		Student student=(Student) session.getAttribute("student");
		Admin admin=(Admin) session.getAttribute("admin");
		if(admin!=null) {
			return AjaxResult.createBySuccessData(0);
		}
		if(student!=null) {
			return AjaxResult.createBySuccessData(1);
		}
		return AjaxResult.createByError();
	}
	
	//�û��˳�
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:user-login.html";
	}
	
	//�û���¼
	@ResponseBody
	@RequestMapping(value="/u-login",method=RequestMethod.POST)
	public Object userLogin(Student student,String code,HttpSession session) {
		//�ж���֤���Ƿ���ȷ����ȷ������֤������
		String sessionCode =  (String) session.getAttribute("Code");
		//��֤�벻��ȷ
		if(sessionCode==null||code==null||
				sessionCode==""||code==""||!sessionCode.equals(code)) {
			return AjaxResult.createByErrorMsg("��֤�����");
		}
		session.setAttribute("Code",null);
		//��ѯ�û���Ϣ��ͨ���û���������
		student=studentService.userLogin(student);
		if(student!=null) {
			//���û���Ϣ����Session
			session.setAttribute("student", student);
			return AjaxResult.createBySuccess();
		}
		return AjaxResult.createByErrorMsg("�û������������");
	}
	
	//������֤�룬������Code
	@RequestMapping("/jcaptcha.jpg")
	public Object execute(HttpServletRequest request,HttpServletResponse response) throws IOException {
	    response.setHeader("Progma", "No-cache");
	    response.setHeader("Cache-Control", "No-cache");
	    response.setDateHeader("Expires", 0);
	    response.setContentType("image/jpeg");
	    int width = 100,height=30;
	    BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	    Graphics g = image.getGraphics();
	    Random random = new Random();
	    g.setColor(getRandomColor(200,250));
	    g.fillRect(0, 0, width, height);
	    g.setFont(new Font("Times New Roman",Font.PLAIN,30));
	    g.setColor(getRandomColor(160,200));
	    for(int i=0;i<130;i++) {
	        int x = random.nextInt(width);
	        int y = random.nextInt(height);
	        int x1 = random.nextInt(12);
	        int y1 = random.nextInt(12);
	        g.drawLine(x, y, x1, y1);
	    }
	    String strCode="";
	    for(int i=0;i<4;i++) {
	        String strNumber = String.valueOf(random.nextInt(10));
	        strCode += strNumber;
	        g.setColor(new Color(15+random.nextInt(120),15+random.nextInt(120),15+random.nextInt(120)));
	        g.drawString(strNumber, 20*i+14, 24);
	    }
	    request.getSession().setAttribute("Code", strCode);
	    g.dispose();
	    ImageIO.write(image, "JPEG", response.getOutputStream());
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	    return null;
	}
    
    private Color getRandomColor(int fc, int bc) {
        Random random = new Random();
        Color randomColor = null;
        if(fc>255)fc = 255;
        if(bc>255)bc = 255;
        int r = fc+random.nextInt(bc-fc);
        int g = fc+random.nextInt(bc-fc);
        int b = fc+random.nextInt(bc-fc);
        randomColor = new Color(r,g,b);
        return randomColor;
    }

}
