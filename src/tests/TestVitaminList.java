package tests;

import org.junit.jupiter.api.*;
import junit.framework.TestCase;
import lists.VitaminList;
import main.*;


class TestVitaminList extends TestCase {
	
	@Test
	@DisplayName("add()")
	public void testAdd1() {
		Vitamin vitamin = new Vitamin("m1");
		Amount<Vitamin> mAmount = new Amount<Vitamin>(vitamin, 10);
		VitaminList ml = new VitaminList();
		ml.add(mAmount);
		assertEquals(vitamin, ml.getVitaminList().get(0).getObject());
	}
	
	
	@Test
	@DisplayName("add() (quando a lista já contém o vitamin)")
	public void testAdd2() {
		Vitamin vitamin = new Vitamin("m1");
		Amount<Vitamin> mAmount = new Amount<Vitamin>(vitamin, 10);
		VitaminList ml = new VitaminList();
		ml.add(mAmount);
		ml.add(mAmount);
		assertEquals(20.0, ml.getVitaminList().get(0).getAmount());
	}
	
	
	@Test
	@DisplayName("searchByName()")
	public void testSearchByName() {
		Vitamin vitamin1 = new Vitamin("m1");
		Vitamin vitamin2 = new Vitamin("m2");
		Amount<Vitamin> mAmount1 = new Amount<Vitamin>(vitamin1, 10);
		Amount<Vitamin> mAmount2 = new Amount<Vitamin>(vitamin2, 5);
		VitaminList ml = new VitaminList();
		ml.add(mAmount1);
		ml.add(mAmount2);
		assertEquals(mAmount2, ml.searchByName("m2"));
	}
	
	
	@Test
	@DisplayName("sum()")
	public void testSum() {
		Vitamin vitamin1 = new Vitamin("m1");
		Vitamin vitamin2 = new Vitamin("m2");
		Amount<Vitamin> mAmount1 = new Amount<Vitamin>(vitamin1, 10);
		Amount<Vitamin> mAmount2 = new Amount<Vitamin>(vitamin2, 5);
		VitaminList ml1 = new VitaminList();
		VitaminList ml2 = new VitaminList();
		ml1.add(mAmount1);
		ml2.add(mAmount2);
		ml1.sum(ml2);
		assertEquals(mAmount2, ml1.getVitaminList().get(1));
	}
	
	
	@Test
	@DisplayName("proportionTo()")
	public void testProportional() {
		Vitamin vitamin = new Vitamin("m1");
		Amount<Vitamin> mAmount = new Amount<Vitamin>(vitamin, 10);
		VitaminList ml = new VitaminList();
		ml.add(mAmount);
		assertEquals(0.1, ml.proportionTo(100).getVitaminList().get(0).getAmount());
	}
	
	
	@Test
	@DisplayName("multiply()")
	public void testMultiply() {
		Vitamin vitamin = new Vitamin("m1");
		Amount<Vitamin> mAmount = new Amount<Vitamin>(vitamin, 10);
		VitaminList ml = new VitaminList();
		ml.add(mAmount);
		ml.multiply(2);
		assertEquals(20.0, ml.getVitaminList().get(0).getAmount());
	}
}
