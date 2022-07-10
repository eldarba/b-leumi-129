package app.core.beans.vehicles;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BasicGear implements Gear {

	@Override
	public void setDrive() {
		System.out.println("Basic Drive");
	}

	@Override
	public void setNeutral() {
		System.out.println("Basic Neutral");
	}

	@Override
	public void setParking() {
		System.out.println("Basic Parking");
	}

	@Override
	public void setReverse() {
		System.out.println("Basic Reverse");
	}

}
