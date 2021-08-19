package tests;

import org.junit.jupiter.api.*;
import junit.framework.TestCase;
import main.*;

class TestNutriValue extends TestCase{
	
	@Test
	@DisplayName("addMineral()")
	public void testAddMineral() {
		Mineral mineral = new Mineral("m1");
		NutriValue nv = new NutriValue();
		nv.addMineral(mineral, 10);
		assertEquals(mineral, nv.getMineralList().getMineralList().get(0).getObject());
	}
	
	
	@Test
	@DisplayName("addVitamin()")
	public void testAddVitamin() {
		Vitamin vitamin = new Vitamin("v1");
		NutriValue nv = new NutriValue();
		nv.addVitamin(vitamin, 10);
		assertEquals(vitamin, nv.getVitaminList().getVitaminList().get(0).getObject());
	}
	
	
	@Test
	@DisplayName("sum()")
	public void testSum() {
		NutriValue nv1 = new NutriValue(100, 50);
		NutriValue nv2 = new NutriValue(100, 50);
		nv1.sum(nv2);
		assertEquals(200.0, nv1.getServingSize());
	}
	
	
	@Test
	@DisplayName("proportional()")
	public void testProportional() {
		NutriValue nv1 = new NutriValue(100, 50);
		assertEquals(0.5, nv1.proportional().getCalories());
	}
	
	
	@Test
	@DisplayName("multiply()")
	public void testMultiply() {
		NutriValue nv1 = new NutriValue(100, 50);
		nv1.multiply(2);
		assertEquals(200.0, nv1.getServingSize());
	}
}
