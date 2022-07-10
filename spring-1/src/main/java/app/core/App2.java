package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Point;

public class App2 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Config.class);) {
			// getting beans:
			// option 1
			Point p1 = ctx.getBean(Point.class);
			System.out.println(p1);

			// option 2
			Point p2 = (Point) ctx.getBean("point");;
			System.out.println(p2);

			// option 3
			Point p3 = ctx.getBean("point", Point.class);
			System.out.println(p3);
			
			
			
			String[] beans = ctx.getBeanDefinitionNames();
			System.out.println("===========");
			for (String beanDefName : beans) {
				System.out.println(beanDefName);
			}
			System.out.println("===========");

		}

	}

}
