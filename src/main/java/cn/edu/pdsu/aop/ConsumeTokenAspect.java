package cn.edu.pdsu.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  消费Token
 *  如果不使用，可以到SpringMVC配置文件关闭AOP
 * @author Administrator
 */
@Aspect
@Component
public class ConsumeTokenAspect {
	@Autowired
	private HttpSession session;
	
	@Pointcut("@annotation(cn.edu.pdsu.aop.ConsumeToken)")
	public void token() {}
	
	//消费token
	@Before(value="token()")
	public void produceToken() throws CommitException {
		Boolean token = (Boolean) session.getAttribute("token");
		if(token==null) {
			throw new CommitException();
		}else {
			session.setAttribute("token", null);
		}
		
		
	}
}
