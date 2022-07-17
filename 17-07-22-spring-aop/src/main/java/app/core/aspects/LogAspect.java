package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	// in an aspect we define advices
	// each advice is a method
	// pointcut is an expression to match an advice to joinpoint (application method)
	@Before("execution(void buyHouse())")
	public void logBuyHouse() {
		System.out.println(">>> before buy house");
	}

}
