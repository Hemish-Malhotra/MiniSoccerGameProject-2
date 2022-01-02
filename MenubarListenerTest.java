package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import view.GamePanel;

class MenubarListenerTest {

	@Test
	void testMenubarListener() {
		GamePanel gp = GamePanel.getGamePanelInstance();
		MenubarListener ml = new MenubarListener(gp);
		assertEquals(gp, ml.getGamePanel());		
	}

	@Test
	void testgetGamePanel() {
		GamePanel gp = GamePanel.getGamePanelInstance();
		MenubarListener ml = new MenubarListener(gp);
		assertEquals(gp, ml.getGamePanel());		
	}

}
