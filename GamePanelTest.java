package view;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

class GamePanelTest {

	@Test
	void testGetGamePanelInstance() {
		GamePanel gp1 = GamePanel.getGamePanelInstance();
		GamePanel gp2 = GamePanel.getGamePanelInstance();
		assertEquals(gp1, gp2);
	}

	@Test
	void testSetupSoccerGame() {
		GamePanel gp = GamePanel.getGamePanelInstance();
		assertNotEquals(null, gp.getGame());
	}

	@Test
	void testGetGame() {
		GamePanel gp = GamePanel.getGamePanelInstance();
		assertNotEquals(null, gp.getGame());
	}

}
