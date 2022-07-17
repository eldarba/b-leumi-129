package app.core;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.businnes.Calculator;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class App2 {

	public static void main(String[] args) throws InterruptedException {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class);
				Scanner sc = new Scanner(System.in)) {

			Calculator calc = ctx.getBean(Calculator.class);
			calc.add(100, 5);
			calc.sub(100, 5);

		} catch (Exception e) {
			// System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
