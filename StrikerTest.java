package model.players;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Point;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import model.SoccerBall;

class StrikerTest {

	@Test
	void testMoveLeft() {
		Striker s = new Striker("striker1", Color.black);
		s.moveLeft();
		assertEquals(495, s.getPlayerPosition().getX());
		assertEquals(450, s.getPlayerPosition().getY());
		s.setPlayerPosition(new Point(10, 450));
		s.moveLeft();
		assertEquals(10, s.getPlayerPosition().getX());
		assertEquals(450, s.getPlayerPosition().getY());
	}

	@Test
	void testMoveRight() {
		Striker s = new Striker("striker1", Color.black);
		s.moveRight();
		assertEquals(505, s.getPlayerPosition().getX());
		assertEquals(450, s.getPlayerPosition().getY());
		s.setPlayerPosition(new Point(550, 450));
		s.moveRight();
		assertEquals(550, s.getPlayerPosition().getX());
		assertEquals(450, s.getPlayerPosition().getY());
	}

	@Test
	void testMoveUp() {
		Striker s = new Striker("striker1", Color.black);
		s.moveUp();
		assertEquals(500, s.getPlayerPosition().getX());
		assertEquals(445, s.getPlayerPosition().getY());
		s.setPlayerPosition(new Point(500, 200));
		s.moveUp();
		assertEquals(500, s.getPlayerPosition().getX());
		assertEquals(200, s.getPlayerPosition().getY());
	}

	@Test
	void testMoveDown() {
		Striker s = new Striker("striker1", Color.black);
		s.moveDown();
		assertEquals(500, s.getPlayerPosition().getX());
		assertEquals(450, s.getPlayerPosition().getY());
		s.setPlayerPosition(new Point(500, 400));
		s.moveDown();
		assertEquals(500, s.getPlayerPosition().getX());
		assertEquals(405, s.getPlayerPosition().getY());
	}

	@Test
	void testShootBall() {
		Striker s = new Striker("striker1", Color.black);
		SoccerBall.getSoccerBall().setPosition(new Point(500, 450));
		s.shootBall();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {}
		assertEquals(500, SoccerBall.getSoccerBall().getPosition().getX());
		assertEquals(209, SoccerBall.getSoccerBall().getPosition().getY());
	}

	@Test
	void testSetInitialPosition() {
		Striker s = new Striker("striker1", Color.black);
		s.setInitialPosition();
		assertEquals(500, s.getPlayerPosition().getX());
		assertEquals(450, s.getPlayerPosition().getY());
	}

	@Test
	void testToString() {
		Striker s = new Striker("striker1", Color.black);
		s.setPlayerStatistics(11);
		assertEquals("striker1 scored 11 goals", s.toString());
	}

	@Test
	void testStriker() {
		Striker s = new Striker("striker1", Color.black);
		assertEquals("striker1", s.getPlayerName());
		assertEquals(Color.black, s.getPlayerColor());
		assertEquals(500, s.getPlayerPosition().getX());
		assertEquals(450, s.getPlayerPosition().getY());
		s.setPlayerStatistics(15);
		assertEquals(15, s.getPlayerStatistics());
	}

}
