package model.players;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.SoccerBall;

class GamePlayerTest {

	@Test
	void testGamePlayer() {
		GamePlayer gp = new Goalkeeper("player1", Color.red);
		assertEquals("player1", gp.getPlayerName(), "Should return same name");
		assertEquals(Color.red, gp.getPlayerColor(), "Should return same color");
	}

	@Test
	void testIsPlayerHasBall() {
		GamePlayer gp = new Goalkeeper("player1", Color.red);
		Point center = new Point(gp.getPlayerPosition().x + 15, gp.getPlayerPosition().y + 30);
		assertEquals(center.distance(SoccerBall.getSoccerBall().getPosition()) < 55, gp.isPlayerHasBall());
	}

	@Test
	void testGrabsBall_1() {
		GamePlayer gp = new Goalkeeper("player1", Color.red);
		gp.setPlayerPosition(new Point(10, 0));
		SoccerBall b = SoccerBall.getSoccerBall();
		b.setPosition(new Point(20, 0));
		gp.grabsBall();
		assertEquals(0, b.getPosition().getX(), "X position should be 0");
		assertEquals(55, b.getPosition().getY(), "Y position should be 55");		
	}

	@Test
	void testGrabsBall_2() {
		GamePlayer gp = new Goalkeeper("player1", Color.red);
		gp.setPlayerPosition(new Point(0, 0));
		SoccerBall b = SoccerBall.getSoccerBall();
		b.setPosition(new Point(20, 0));
		gp.grabsBall();
		assertEquals(20, b.getPosition().getX(), "X position should be 20");
		assertEquals(55, b.getPosition().getY(), "Y position should be 55");		
	}
	
	@Test
	void testGetPlayerName() {
		GamePlayer gp = new Goalkeeper("player1", Color.red);
		assertEquals("player1", gp.getPlayerName(), "Should return same name");
	}

	@Test
	void testGetPlayerColor() {
		GamePlayer gp = new Goalkeeper("player1", Color.red);
		assertEquals(Color.red, gp.getPlayerColor(), "Should return same color");
	}

	@Test
	void testGetPlayerPosition() {
		GamePlayer gp = new Goalkeeper("player1", Color.red);
		gp.setPlayerPosition(new Point(0, 10));
		assertEquals(0, gp.getPlayerPosition().getX(), "X position should be 0");
		assertEquals(10, gp.getPlayerPosition().getY(), "Y position should be 10");
	}

	@Test
	void testSetPlayerPosition() {
		GamePlayer gp = new Goalkeeper("player1", Color.red);
		gp.setPlayerPosition(new Point(250, 310));
		assertEquals(250, gp.getPlayerPosition().getX(), "X position should be 250");
		assertEquals(310, gp.getPlayerPosition().getY(), "Y position should be 310");
	}

	@Test
	void testGetPlayerStatistics() {
		GamePlayer gp = new Goalkeeper("player1", Color.red);
		gp.setPlayerStatistics(1);
		assertEquals(1, gp.getPlayerStatistics(), "It should return 1");
	}

	@Test
	void testSetPlayerStatistics() {
		GamePlayer gp = new Goalkeeper("player1", Color.red);
		gp.setPlayerStatistics(15);
		assertEquals(15, gp.getPlayerStatistics(), "It should return 15");
	}

	@Test
	void testCompareTo_1() {
		GamePlayer gp1 = new Goalkeeper("player1", Color.red);
		gp1.setPlayerStatistics(1);
		GamePlayer gp2 = new Goalkeeper("player2", Color.blue);
		gp2.setPlayerStatistics(15);
		assertEquals(true, gp1.compareTo(gp2) > 0);
	}

	@Test
	void testCompareTo_2() {
		GamePlayer gp1 = new Goalkeeper("player1", Color.red);
		gp1.setPlayerStatistics(100);
		GamePlayer gp2 = new Goalkeeper("player2", Color.blue);
		gp2.setPlayerStatistics(15);
		assertEquals(true, gp1.compareTo(gp2) < 0);
	}

}
