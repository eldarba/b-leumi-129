package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.businnes.purchase.RealEstatePurchase;
import app.core.businnes.sales.RealEstateSales;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class App {

	public static void main(String[] args) throws InterruptedException {
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class)){
			
			RealEstatePurchase realEstatePurchase = ctx.getBean(RealEstatePurchase.class);
			RealEstateSales realEstateSales = ctx.getBean(RealEstateSales.class);
			
			
			realEstatePurchase.buyHouse(3);
			realEstatePurchase.buyHouse();
			realEstateSales.saleHouse();
		}
	}

}
