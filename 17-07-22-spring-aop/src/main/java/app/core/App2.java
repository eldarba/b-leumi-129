package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.aspects.StatisticsAspect;
import app.core.businnes.purchase.RealEstatePurchase;
import app.core.businnes.sales.Chair;
import app.core.businnes.sales.FurnitureSales;
import app.core.businnes.sales.RealEstateSales;
import app.core.businnes.sales.Table;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class App2 {

	public static void main(String[] args) throws InterruptedException {
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class)){
			
			RealEstatePurchase realEstatePurchase = ctx.getBean(RealEstatePurchase.class);
			RealEstateSales realEstateSales = ctx.getBean(RealEstateSales.class);
			FurnitureSales furnitureSales = ctx.getBean(FurnitureSales.class);
			
			
			realEstatePurchase.buyHouse(3);
			realEstatePurchase.buyHouse();
			realEstateSales.saleHouse();
			realEstateSales.saleHouse(3);
			realEstateSales.saleStore();
			realEstateSales.check();
			realEstateSales.validate();
			furnitureSales.sale(new Table());
			furnitureSales.sale(new Table());
			furnitureSales.sale(new Chair());
			
			
			System.out.println("====================");
			// check statistics:
			StatisticsAspect statisticsAspect = ctx.getBean(StatisticsAspect.class);
			System.out.println("number of sales: " + statisticsAspect.getAllSalesCount());
			System.out.println("number of table sales: " + statisticsAspect.getTableSalesCount());
			System.out.println("number of chair sales: " + statisticsAspect.getChairSalesCount());
			System.out.println("number of furniture sales: " + statisticsAspect.getFurnitureSalesCount());
		}
	}

}
