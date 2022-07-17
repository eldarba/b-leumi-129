package app.core.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	// pointcut expression contains:
	// modifiers
	// return type - mandatory
	// package
	// type
	// method name - mandatory
	// parameters - mandatory
	// throws
	
	// wild cards
	// * any - identifier
	// buy* - identifier starts with
	// () - no parameters
	// (type1, type2) - specific parameters
	// (*) - 1 parameter of any type
	// (..) - 0 or more parameters of any type
	
	// in an aspect we define advices
	// each advice is a method
	// pointcut is an expression to match an advice to joinpoint (application method)
	@Before("execution(* buyHouse(..))")
	public void logBuyHouse(JoinPoint jp) {
		// JoinPoint is a reference to the intercepted method
		Object[] args = jp.getArgs();
		System.out.println(">>> before buy house: " + jp.getSignature().getName() + ". args: " + Arrays.toString(args));
	}

}
