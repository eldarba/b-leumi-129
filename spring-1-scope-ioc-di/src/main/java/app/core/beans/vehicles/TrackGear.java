package app.core.beans.vehicles;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TrackGear implements Gear {

	@Override
	public void setDrive() {
		System.out.println("TrackGear Drive");
	}

	@Override
	public void setNeutral() {
		System.out.println("TrackGear Neutral");
	}

	@Override
	public void setParking() {
		System.out.println("TrackGear Parking");
	}

	@Override
	public void setReverse() {
		System.out.println("TrackGear Reverse");
	}

}
