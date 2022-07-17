package app.core.businnes.sales;

import org.springframework.stereotype.Component;

@Component
public class FurnitureSales {

	public void sale(Table table) {
		System.out.println("a table was sold");
	}

	public void sale(Chair chair) {
		System.out.println("a chair was sold");
	}

}
