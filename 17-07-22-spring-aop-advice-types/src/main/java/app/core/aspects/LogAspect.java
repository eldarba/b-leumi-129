package app.core.aspects;

import java.util.LinkedHashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	private Map<Integer, String> map = new LinkedHashMap<>();
	private int c;

	@Before("div()")
	public void beforeDiv(JoinPoint jp) {
		System.out.println(">>> before: " + jp.getSignature().getName());
	}

	@After("div()")
	public void afterDiv(JoinPoint jp) {
		System.out.println(">>> after: " + jp.getSignature().getName());
	}
	
	@AfterReturning(pointcut = "div()", returning = "theReturndVal")
	public void afterDivReturns(JoinPoint jp, String theReturndVal) {
		System.out.println(">>> AfterReturning: " + jp.getSignature().getName() + " - returned: " + theReturndVal);
		map.put(++c, theReturndVal);
	}
	
	@AfterThrowing(pointcut = "div()", throwing = "e")
	public void afterDivThrows(JoinPoint jp, Throwable e) {
		System.out.println(">>> AfterThrowing: " + jp.getSignature().getName() + " - threw: " + e);
	}
	
	public void printHistory() {
		System.out.println("calculator results history:");
		for (int key : map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
		System.out.println("===========================");
	}
	
	public void clearHistory() {
		this.map.clear();
		this.c = 0;
	}
	

	@Pointcut("execution(java.lang.String divide(int, int))")
	public void div() {
	};
}
