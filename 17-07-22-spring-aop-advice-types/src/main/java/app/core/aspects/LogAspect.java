package app.core.aspects;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

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
		successMap.put(++successCount, theReturndVal);
	}

	@AfterThrowing(pointcut = "div()", throwing = "e")
	public void afterDivThrows(JoinPoint jp, Throwable e) {
		System.out.println(">>> AfterThrowing: " + jp.getSignature().getName() + " - threw: " + e);
		this.errorMap.put(LocalDateTime.now(), e);
	}

	@Around("div()")
	public Object arroundDiv(ProceedingJoinPoint jp) throws Throwable {
		// ====== before
		System.out.println(">>> @Around: before");
		Object res;
		if (LocalTime.now().isBefore(LocalTime.of(8, 00, 0))) {
			try {
				res = jp.proceed(); // invoking joinpoint (business)
			} catch (ArithmeticException e) {
				res = "infinity";
			}

		} else {
			res = "no service at this time";
		}
		// ====== after
		System.out.println(">>> @Around: after");
		return res;
	}

	@Before("annotatedClass()")
	public void beforeMyAnnotation(JoinPoint jp) {
		System.out.println(">>>@@@ @Before: MyAnotation: " + jp.getSignature().getName());
	}
	
	// POINTCUTS

	// no annotations in business
	@Pointcut("execution(java.lang.String divide(Integer, Integer))")
	public void div() {
	}

	// for annotations on methods
	@Pointcut("@annotation(app.core.aspects.annotations.MyLogAnnotation)")
	public void annotatedMethod() {
	}

	// for annotations on class
	@Pointcut("@target(app.core.aspects.annotations.MyLogAnnotation)")
	public void annotatedClass() {
	}

	// other members for aspect logic
	private Map<Integer, String> successMap = new LinkedHashMap<>();
	private int successCount;
	private Map<LocalDateTime, Throwable> errorMap = new LinkedHashMap<>();

	public void printErrorHistory() {
		System.out.println("======== calculator error history:");
		for (LocalDateTime key : errorMap.keySet()) {
			System.out.println(key + ": " + errorMap.get(key));
		}
		System.out.println("=================================");
	}

	public void printSuccessHistory() {
		System.out.println("===== calculator results history:");
		for (int key : successMap.keySet()) {
			System.out.println(key + ") " + successMap.get(key));
		}
		System.out.println("=================================");
	}

	public void clearSuccessHistory() {
		this.successMap.clear();
		this.successCount = 0;
	}

}
