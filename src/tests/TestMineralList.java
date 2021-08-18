package tests;

import org.junit.jupiter.api.*;
import junit.framework.TestCase;
import main.*;
import lists.*;

class TestMineralList extends TestCase {
	
	
	@Test
	@DisplayName("add()")
	public void testAdd1() {
		Mineral mineral = new Mineral("m1");
		Amount<Mineral> mAmount = new Amount<Mineral>(mineral, 10);
		MineralList ml = new MineralList();
		ml.add(mAmount);
		assertEquals(mineral, ml.getMineralList().get(0).getObject());
	}
	
	
	@Test
	@DisplayName("add() (quando a lista já contém o mineral)")
	public void testAdd2() {
		Mineral mineral = new Mineral("m1");
		Amount<Mineral> mAmount = new Amount<Mineral>(mineral, 10);
		MineralList ml = new MineralList();
		ml.add(mAmount);
		ml.add(mAmount);
		assertEquals(20.0, ml.getMineralList().get(0).getAmount());
	}
	
	
	@Test
	@DisplayName("searchByName()")
	public void testSearchByName() {
		Mineral mineral1 = new Mineral("m1");
		Mineral mineral2 = new Mineral("m2");
		Amount<Mineral> mAmount1 = new Amount<Mineral>(mineral1, 10);
		Amount<Mineral> mAmount2 = new Amount<Mineral>(mineral2, 5);
		MineralList ml = new MineralList();
		ml.add(mAmount1);
		ml.add(mAmount2);
		assertEquals(mAmount2, ml.searchByName("m2"));
	}
	
	
	@Test
	@DisplayName("sum()")
	public void testSum() {
		Mineral mineral1 = new Mineral("m1");
		Mineral mineral2 = new Mineral("m2");
		Amount<Mineral> mAmount1 = new Amount<Mineral>(mineral1, 10);
		Amount<Mineral> mAmount2 = new Amount<Mineral>(mineral2, 5);
		MineralList ml1 = new MineralList();
		MineralList ml2 = new MineralList();
		ml1.add(mAmount1);
		ml2.add(mAmount2);
		ml1.sum(ml2);
		assertEquals(mAmount2, ml1.getMineralList().get(1));
	}
	
	
	@Test
	@DisplayName("proportionTo()")
	public void testProportional() {
		Mineral mineral = new Mineral("m1");
		Amount<Mineral> mAmount = new Amount<Mineral>(mineral, 10);
		MineralList ml = new MineralList();
		ml.add(mAmount);
		assertEquals(0.1, ml.proportionTo(100).getMineralList().get(0).getAmount());
	}
	
	
	@Test
	@DisplayName("multiply()")
	public void testMultiply() {
		Mineral mineral = new Mineral("m1");
		Amount<Mineral> mAmount = new Amount<Mineral>(mineral, 10);
		MineralList ml = new MineralList();
		ml.add(mAmount);
		ml.multiply(2);
		assertEquals(20.0, ml.getMineralList().get(0).getAmount());
	}
}
