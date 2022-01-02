package model.players;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerCollectionTest {

	@Test
	void testPlayerCollection() {
		PlayerCollection pc = new PlayerCollection();
		assertNotEquals(null, pc.getList());
	}

	@Test
	void testAdd() {
		PlayerCollection pc = new PlayerCollection();
		Goalkeeper gk = new Goalkeeper("pctest", Color.blue);
		pc.add(gk);
		assertEquals(gk, pc.getList().get(0));
	}

	@Test
	void testGet() {
		PlayerCollection pc = new PlayerCollection();
		assertEquals(null, pc.get(null));
		assertEquals(null, pc.get("Goalkeeper"));
		Goalkeeper gk = new Goalkeeper("pctest", Color.blue);
		pc.add(gk);
		assertEquals(gk, pc.get("Goalkeeper"));
	}

	@Test
	void testSort() {
		PlayerCollection pc = new PlayerCollection();
		Goalkeeper gk1 = new Goalkeeper("keeper1", Color.blue);
		gk1.setPlayerStatistics(10);
		Goalkeeper gk2 = new Goalkeeper("keeper2", Color.red);
		gk2.setPlayerStatistics(100);
		pc.add(gk1);
		pc.add(gk2);
		pc.sort();
		assertEquals(gk2.getPlayerStatistics(), pc.getList().get(0).getPlayerStatistics());
	}

	@Test
	void testGetList() {
		PlayerCollection pc = new PlayerCollection();
		assertEquals(0, pc.getList().size());
		Goalkeeper gk1 = new Goalkeeper("keeper1", Color.blue);
		Goalkeeper gk2 = new Goalkeeper("keeper2", Color.red);
		pc.add(gk1);
		pc.add(gk2);
		assertEquals(2, pc.getList().size());
	}

	@Test
	void testIterator() {
		PlayerCollection pc = new PlayerCollection();
		assertEquals("PlayerCollectionIterator", pc.iterator().getClass().getSimpleName());
	}

}
