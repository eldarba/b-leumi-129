package app.core.businnes;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	public String divide(int a, int b) throws ArithmeticException {
		String res = a + " : " + b + " = " + (a / b);
		System.out.println(res);
		return res;
	}

}
 