package app.core.businnes.sales;

import org.springframework.stereotype.Component;

@Component
public class RealEstateSales {

	public void saleHouse() {
		System.out.println("A house was sold");
	}

	public void saleHouse(int amount) {
		System.out.println(amount + " Houses were sold");
	}

	public int saleStore() {
		System.out.println("Store was sold");
		return 0;
	}

	public void check() {
		System.out.println("just checking");
	}

	public void validate() {
		System.out.println("validating");
	}

}
