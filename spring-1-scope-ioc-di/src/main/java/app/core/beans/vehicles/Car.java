package app.core.beans.vehicles;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	private Engine engine;
	private Gear gear;

	public Car() {
	}

	@Autowired // DI - Dependency Injection
	public Car(Engine turboEngine, @Qualifier("basicGear") Gear gear) {
		super();
		this.engine = turboEngine;
		this.gear = gear;
	}

	public Car(Engine engine) {
		super();
		this.engine = engine;
	}

	public Car(Gear gear) {
		super();
		this.gear = gear;
	}

	@Override
	public void move() {
		this.engine.turnOn();
		this.gear.setDrive();
		System.out.println("Car moves");
		System.out.println("==============");
	}

	@Override
	public void stop() {
		this.gear.setParking();
		this.engine.turnOff();
		System.out.println("Car stopped");
		System.out.println("==============");
	}

}
