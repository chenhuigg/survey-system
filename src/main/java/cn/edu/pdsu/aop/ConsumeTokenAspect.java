package cn.edu.pdsu.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  ����Token
 *  �����ʹ�ã����Ե�SpringMVC�����ļ��ر�AOP
 * @author Administrator
 */
@Aspect
@Component
public class ConsumeTokenAspect {
	@Autowired
	private HttpSession session;
	
	@Pointcut("@annotation(cn.edu.pdsu.aop.ConsumeToken)")
	public void token() {}
	
	//����token
	/*@Before(value="token()")
	public void consumeToken() throws CommitException {
		Boolean token = (Boolean) session.getAttribute("token");
		if(token==null) {
			throw new CommitException();
		}else {
			session.setAttribute("token", null);
		}
	}*/
	
	//����token
	@Around(value="token()")
	public Object consumeToken(ProceedingJoinPoint joinPoint) throws Throwable {
		//HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Boolean token = (Boolean) session.getAttribute("token");
		if(token==null) {
			return null;
		}else {
			session.setAttribute("token", null);
		}
		Object[] args = joinPoint.getArgs();
		Object proceed = joinPoint.proceed(args);
		return proceed;
	}
	
}
