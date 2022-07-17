package app.core;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.aspects.LogAspect;
import app.core.businnes.Calculator;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class App {

	public static void main(String[] args) throws InterruptedException {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
				Scanner sc = new Scanner(System.in)) {
			Calculator calc = ctx.getBean(Calculator.class);
			calc.divide(100, 0);

			
			
			//			System.out.print("enter a: ");
//			int a = sc.nextInt();
//			System.out.print("enter b: ");
//			int b = sc.nextInt();
//			calc.divide(100, 5);
//			calc.divide(45, 7);
//			calc.divide(1000, 300);
//			
//			LogAspect logAspect = ctx.getBean(LogAspect.class);
//			logAspect.printHistory();
//			
//			logAspect.clearHistory();
//			calc.divide(2, 4);
//			calc.divide(100, 28);
//			calc.divide(10, 10);
//			logAspect.printHistory();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
