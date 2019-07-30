package cn.edu.pdsu.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  生产Token
 *  如果不使用，可以到SpringMVC配置文件关闭AOP
 * @author Administrator
 */
@Aspect
@Component
public class ProduceTokenAspect {
	
	@Autowired
	private HttpSession session;
	
	@Pointcut("@annotation(cn.edu.pdsu.aop.ProduceToken)")
	public void token() {}
	
	//生产token
	@Before(value="token()")
	public void produceToken() {
		session.setAttribute("token",true);
	}
}
