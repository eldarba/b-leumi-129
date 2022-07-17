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

	public void saleStore() {
		System.out.println("Store was sold");
	}

}
