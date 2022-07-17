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

			for (int i = 0; i < 25; i++) {
				try {
					Integer a = (int) (Math.random() * 6);
					Integer b = (int) (Math.random() * 6);
					a = a == 3 ? null : a;
					calc.divide(a, b);
					Thread.sleep(300);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			System.out.println("\n\n\n");
			LogAspect logAspect = ctx.getBean(LogAspect.class);
			logAspect.printSuccessHistory();
			System.out.println("\n\n\n");
			logAspect.printErrorHistory();
			

			System.out.println("\n\n\n");
			System.out.println("CLEAR SUCCESS HISTORY");
			logAspect.clearSuccessHistory();
			calc.divide(2, 4);
			calc.divide(100, 28);
			calc.divide(10, 10);
			logAspect.printSuccessHistory();

		} catch (Exception e) {
			//System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
