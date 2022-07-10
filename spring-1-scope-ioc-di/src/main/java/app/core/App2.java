package app.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import app.core.beans.bank.Bank;
import app.core.beans.vehicles.Car;
import app.core.beans.vehicles.Gear;
import app.core.beans.vehicles.TurboEngine;
import app.core.beans.vehicles.Vehicle;

@ComponentScan
@Configuration
@PropertySource("application.properties")
public class App2 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class)) {
			Bank bank = ctx.getBean(Bank.class);
			System.out.println(bank);
		}

	}

}
