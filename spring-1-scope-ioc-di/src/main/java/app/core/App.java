package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import app.core.beans.vehicles.Car;
import app.core.beans.vehicles.TurboEngine;
import app.core.beans.vehicles.Vehicle;

@ComponentScan
@Configuration
public class App {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(App.class)) {
			
			Vehicle vehicle = ctx.getBean("car", Vehicle.class);
			vehicle.move();
			
			Vehicle turboCar = ctx.getBean("turboCar", Vehicle.class);
			turboCar.move();
		}

	}
	
	@Bean
	@Scope("prototype")
	public Car turboCar(TurboEngine engine) {
		Car car = new Car(engine);
		return car;
	}

}
