package app.core.businnes;

import org.springframework.stereotype.Component;

import app.core.aspects.annotations.MyLogAnnotation;

@Component
@MyLogAnnotation
public class Calculator {

	public String divide(Integer a, Integer b) throws ArithmeticException, NullPointerException {
		String res = a + " : " + b + " = " + (a / b);
		System.out.println(res);
		return res;
	}

	public String add(Integer a, Integer b) {
		String res = a + " + " + b + " = " + (a + b);
		System.out.println(res);
		return res;
	}

	public String sub(Integer a, Integer b) {
		String res = a + " - " + b + " = " + (a - b);
		System.out.println(res);
		return res;
	}

}
