package app.core.beans.vehicles;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class TurboEngine implements Engine {
	private static int c = 3001;
	private int id = c++;

	@Override
	public void turnOn() {
		System.out.println("TurboEngine ON");
	}

	@Override
	public void turnOff() {
		System.out.println("TurboEngine OFF");
	}

}
