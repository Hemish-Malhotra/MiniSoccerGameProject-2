package model.players;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class PlayerCollectionIteratorTest {

	@Test
	void testPlayerCollectionIterator() {
		PlayerCollection pc = new PlayerCollection();
		Goalkeeper gk = new Goalkeeper("keeper1", Color.blue);
		pc.add(gk);
		PlayerCollectionIterator pci = new  PlayerCollectionIterator(pc);
		assertEquals(pc.getList().listIterator().next().getPlayerName(), pci.next().getPlayerName());
	}

	@Test
	void testHasNext() {
		PlayerCollection pc = new PlayerCollection();
		PlayerCollectionIterator pci = new  PlayerCollectionIterator(pc);
		assertEquals(pc.getList().listIterator().hasNext(), pci.hasNext());
		Goalkeeper gk1 = new Goalkeeper("keeper1", Color.blue);
		Goalkeeper gk2 = new Goalkeeper("keeper2", Color.red);
		pc.add(gk1);
		pc.add(gk2);
		pci = new  PlayerCollectionIterator(pc);
		assertEquals(pc.getList().listIterator().hasNext(), pci.hasNext());
	}

	@Test
	void testNext() {
		PlayerCollection pc = new PlayerCollection();
		Goalkeeper gk1 = new Goalkeeper("keeper1", Color.blue);
		Goalkeeper gk2 = new Goalkeeper("keeper2", Color.red);
		pc.add(gk1);
		pc.add(gk2);
		PlayerCollectionIterator pci = new  PlayerCollectionIterator(pc);
		assertEquals(pc.getList().listIterator().next(), pci.next());
	}

	@Test
	void testGetIter() {
		PlayerCollection pc = new PlayerCollection();
		Goalkeeper gk1 = new Goalkeeper("keeper1", Color.blue);
		Goalkeeper gk2 = new Goalkeeper("keeper2", Color.red);
		pc.add(gk1);
		pc.add(gk2);
		PlayerCollectionIterator pci = new  PlayerCollectionIterator(pc);
		assertEquals(pci.getIter().hasNext(), pci.hasNext());
		assertEquals("keeper1", pci.getIter().next().getPlayerName());
		assertEquals("keeper2", pci.getIter().next().getPlayerName());
	}

}
