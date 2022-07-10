package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class App {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(App.class)) {
		}

	}

}
