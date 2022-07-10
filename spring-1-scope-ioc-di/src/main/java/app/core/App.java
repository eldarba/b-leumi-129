package app.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import app.core.beans.vehicles.Car;
import app.core.beans.vehicles.Gear;
import app.core.beans.vehicles.TurboEngine;
import app.core.beans.vehicles.Vehicle;

@ComponentScan
@Configuration
public class App {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class)) {

			Vehicle vehicle = ctx.getBean("car", Vehicle.class);
			vehicle.move();
			vehicle.stop();

			Vehicle turboCar = ctx.getBean("turboCar", Vehicle.class);
			turboCar.move();
			turboCar.stop();

			Vehicle van = ctx.getBean("van", Vehicle.class);
			van.move();
			van.stop();
		}

	}

	@Bean
	@Scope("prototype")
	public Car turboCar(TurboEngine engine, @Qualifier("advancedGear") Gear gear) {
		Car car = new Car(engine, gear);
		return car;
	}

	@Bean
	@Scope("prototype")
	public Car van(TurboEngine engine, Gear trackGear) {
		Car car = new Car(engine, trackGear);
		return car;
	}

}
