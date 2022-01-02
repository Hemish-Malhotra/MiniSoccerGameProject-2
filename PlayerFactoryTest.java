package model.players;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerFactoryTest {

	@Test
	void testGetPlayer() {
		PlayerFactory pf = PlayerFactory.getPlayerFactoryInstance();
		GamePlayer gp1 = pf.getPlayer(null);
		assertEquals(null, gp1);
		GamePlayer gp2 = pf.getPlayer("random");
		assertEquals(null, gp2);
		GamePlayer gp3 = pf.getPlayer("striker");
		assertEquals("Striker", gp3.getClass().getSimpleName());
		assertEquals(Color.blue, gp3.getPlayerColor());
		GamePlayer gp4 = pf.getPlayer("goalkeeper");
		assertEquals("Goalkeeper", gp4.getClass().getSimpleName());
		assertEquals(Color.yellow, gp4.getPlayerColor());
	}

	@Test
	void testGetPlayerFactoryInstance() {
		PlayerFactory pf1 = PlayerFactory.getPlayerFactoryInstance();
		PlayerFactory pf2 = PlayerFactory.getPlayerFactoryInstance();
		assertEquals(pf1, pf2);
	}

}
