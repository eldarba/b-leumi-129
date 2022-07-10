package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App4 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);) {

			Integer r1 = ctx.getBean(Integer.class);
			System.out.println(r1);
			
			Integer r2 = ctx.getBean(Integer.class);
			System.out.println(r2);
			
			Integer r3 = ctx.getBean(Integer.class);
			System.out.println(r3);
		}

	}

}
