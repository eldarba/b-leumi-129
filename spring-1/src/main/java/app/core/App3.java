package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Point;

public class App3 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);) {
			// getting beans:
			// option 1
			Point p1 = ctx.getBean("point100", Point.class);
			System.out.println(p1);

			System.out.println(ctx.getBean(String.class));

//			String[] beans = ctx.getBeanDefinitionNames();
//			System.out.println("===========");
//			for (String beanDefName : beans) {
//				System.out.println(beanDefName);
//			}
//			System.out.println("===========");

		}

	}

}
