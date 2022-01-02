package model.players;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

import org.junit.jupiter.api.Test;

class PlayerStatisticsTest {

	@Test
	void testGetStatistics() {
		Goalkeeper gk = new Goalkeeper("p1", Color.red);
		gk.setPlayerStatistics(10);
		assertEquals(10, gk.getPlayerStatistics());
	}

	@Test
	void testSetStatistics() {
		Striker s = new Striker("p2", Color.blue);
		s.setPlayerStatistics(5);
		assertEquals(5, s.getPlayerStatistics());
	}

	@Test
	void testToString() {
		Striker s = new Striker("p3", Color.orange);
		s.setPlayerStatistics(7);
		assertEquals("7", s.getPlayerStatistics().toString());
	}

}
