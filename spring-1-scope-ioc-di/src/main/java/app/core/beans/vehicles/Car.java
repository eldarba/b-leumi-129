package app.core.beans.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Component
@Scope("prototype")
@Data
@ToString(exclude = "engine")
public class Car implements Vehicle {
	private static int c = 101;
	private int number = c++;
	@Autowired // DI - Dependency Injection
	private Engine engine;

	@Override
	public void move() {
		this.engine.turnOn();
		System.out.println("Car moves");
	}

	@Override
	public void stop() {
		this.engine.turnOff();
		System.out.println("Car stopped");
	}

}
