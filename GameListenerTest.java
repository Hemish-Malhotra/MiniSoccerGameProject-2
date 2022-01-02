package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import view.GamePanel;

class GameListenerTest {

	@Test
	void testGameListener() {
		GamePanel gp = GamePanel.getGamePanelInstance();
		GameListener gl = new GameListener(gp);
		assertEquals(gp, gl.getGamePanel());
		
	}

	@Test
	void testgetGamePanel() {
		GamePanel gp = GamePanel.getGamePanelInstance();
		GameListener gl = new GameListener(gp);
		assertEquals(gp, gl.getGamePanel());		
	}
}
