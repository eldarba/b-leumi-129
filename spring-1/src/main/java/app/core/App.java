package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {

		// spring container - Application Context
		// ARM - Auto Resource Management (try with resources) will close resource by
		// the end of try block
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();) {
			System.out.println("up");

		}

		System.out.println("down");

	}

}
