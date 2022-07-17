package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StatisticsAspect {

	private int allSalesCount;
	private int tableSalesCount;
	private int chairSalesCount;
	private int furnitureSalesCount;

	// advices

	@Before("execution(* app.core.businnes.sales.*.sale*(..))")
	public void countAllSalesAttemps() {
		allSalesCount++;
	}

	@Before("tableSale()")
	public void countAllTableSalesAttemps() {
		tableSalesCount++;
	}

	@Before("chairSale()")
	public void countAllChairSalesAttemps() {
		chairSalesCount++;
	}

	@Before("tableSale() || chairSale()")
	public void countAllFurnitureSalesAttemps() {
		furnitureSalesCount++;
	}

	// pointcuts
	@Pointcut("execution(* app.core.businnes.sales.*.sale*(app.core.businnes.sales.Table))")
	public void tableSale() {
	}

	@Pointcut("execution(* app.core.businnes.sales.*.sale*(app.core.businnes.sales.Chair))")
	public void chairSale() {
	}

	// getters

	public int getAllSalesCount() {
		return allSalesCount;
	}

	public int getTableSalesCount() {
		return tableSalesCount;
	}

	public int getChairSalesCount() {
		return chairSalesCount;
	}

	public int getFurnitureSalesCount() {
		return furnitureSalesCount;
	}

}
