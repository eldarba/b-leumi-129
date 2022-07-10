package app.core.beans.vehicles;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class BasicEngine implements Engine {
	private static int c = 1001;
	private int id = c++;

	@Override
	public void turnOn() {
		System.out.println("BasicEngine ON");
	}

	@Override
	public void turnOff() {
		System.out.println("BasicEngine OFF");
	}

}
