package app.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import app.core.beans.Point;

@ComponentScan
@Configuration
public class Config {
	
	@Bean
	public Point point100(){
		Point p = new Point();
		p.setX(100);
		p.setY(100);
		return p;
	}
	
	@Bean
	public String helloMsg() {
		return "Hello from Spring";
	}
	
	@Bean
	@Scope("prototype")
	public Integer random() {
		return (int) (Math.random()*101);
	}
	

}
