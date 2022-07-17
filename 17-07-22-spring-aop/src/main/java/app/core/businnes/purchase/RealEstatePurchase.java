package app.core.businnes.purchase;

import org.springframework.stereotype.Component;

@Component
public class RealEstatePurchase {

	public void buyHouse() {
		System.out.println("A house was bought");
	}

	public void buyHouse(int amount) {
		System.out.println(amount + " Houses were bought");
	}

	public void buyStore() {
		System.out.println("Store was bought");
	}

}
