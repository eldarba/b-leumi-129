package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@Configuration
@PropertySource("application.properties")
public class App3 {

	public static void main(String[] args) throws InterruptedException {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App3.class)) {
			System.out.println("spring will shut down in 10 seconds");
			
			
			Thread.sleep(10000);
		}
		System.out.println("DOWN");

	}

}
