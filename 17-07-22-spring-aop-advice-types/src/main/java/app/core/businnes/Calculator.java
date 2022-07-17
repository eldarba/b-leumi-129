package app.core.businnes;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	public String divide(Integer a, Integer b) throws ArithmeticException, NullPointerException {
		String res = a + " : " + b + " = " + (a / b);
		System.out.println(res);
		return res;
	}

}
 