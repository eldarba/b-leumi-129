package app.core.beans.vehicles;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AdvancedGear implements Gear {

	@Override
	public void setDrive() {
		System.out.println("Advanced Drive");
	}

	@Override
	public void setNeutral() {
		System.out.println("Advanced Neutral");
	}

	@Override
	public void setParking() {
		System.out.println("Advanced Parking");
	}

	@Override
	public void setReverse() {
		System.out.println("Advanced Reverse");
	}

}
