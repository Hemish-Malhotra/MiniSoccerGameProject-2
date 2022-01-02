package model.players;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.SoccerBall;

class GoalkeeperTest {

	@Test
	void testMoveLeft() {
		Goalkeeper gk = new Goalkeeper("keeper1", Color.orange);
		gk.moveLeft();
		assertEquals(270, gk.getPlayerPosition().getX());
		assertEquals(70, gk.getPlayerPosition().getY());
		gk.setPlayerPosition(new Point(10, 70));
		gk.moveLeft();
		assertEquals(10, gk.getPlayerPosition().getX());
		assertEquals(70, gk.getPlayerPosition().getY());
	}

	@Test
	void testMoveRight() {
		Goalkeeper gk = new Goalkeeper("keeper1", Color.orange);
		gk.moveRight();
		assertEquals(290, gk.getPlayerPosition().getX());
		assertEquals(70, gk.getPlayerPosition().getY());
		gk.setPlayerPosition(new Point(550, 70));
		gk.moveRight();
		assertEquals(550, gk.getPlayerPosition().getX());
		assertEquals(70, gk.getPlayerPosition().getY());
	}

	@Test
	void testMoveUp() {
		Goalkeeper gk = new Goalkeeper("keeper1", Color.orange);
		gk.moveUp();
		assertEquals(280, gk.getPlayerPosition().getX());
		assertEquals(65, gk.getPlayerPosition().getY());
		gk.setPlayerPosition(new Point(280, 3));
		gk.moveUp();
		assertEquals(280, gk.getPlayerPosition().getX());
		assertEquals(3, gk.getPlayerPosition().getY());
	}

	@Test
	void testMoveDown() {
		Goalkeeper gk = new Goalkeeper("keeper1", Color.orange);
		gk.moveDown();
		assertEquals(280, gk.getPlayerPosition().getX());
		assertEquals(75, gk.getPlayerPosition().getY());
		gk.setPlayerPosition(new Point(280, 255));
		gk.moveDown();
		assertEquals(280, gk.getPlayerPosition().getX());
		assertEquals(255, gk.getPlayerPosition().getY());
	}

	@Test
	void testShootBall() {
		Goalkeeper gk = new Goalkeeper("keeper1", Color.orange);
		SoccerBall.getSoccerBall().setPosition(new Point(100, 100));
		gk.shootBall();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {}
		assertEquals(100, SoccerBall.getSoccerBall().getPosition().getX());
		assertEquals(301, SoccerBall.getSoccerBall().getPosition().getY());
	}
	
	@Test
	void testMoveRandomly() {
		Goalkeeper gk = new Goalkeeper("keeper1", Color.orange);
		Point o  = gk.getPlayerPosition();
		gk.moveRandomly();
		if (gk.getMovementStep() == 0) {
			assertEquals(o.getX(), gk.getPlayerPosition().getX());
		}
		else {
			assertNotEquals(o.getX(), gk.getPlayerPosition().getX());
		}
	}

	@Test
	void testSetInitialPosition() {
		Goalkeeper gk = new Goalkeeper("keeper1", Color.orange);
		gk.setInitialPosition();
		assertEquals(280, gk.getPlayerPosition().getX());
		assertEquals(70, gk.getPlayerPosition().getY());
	}

	@Test
	void testToString() {
		Goalkeeper gk = new Goalkeeper("keeper1", Color.orange);
		gk.setPlayerStatistics(10);
		assertEquals("keeper1 caught 10 balls", gk.toString());
	}

	@Test
	void testGoalkeeper() {
		Goalkeeper gk = new Goalkeeper("keeper1", Color.orange);
		assertEquals("keeper1", gk.getPlayerName());
		assertEquals(Color.orange, gk.getPlayerColor());
		assertEquals(280, gk.getPlayerPosition().getX());
		assertEquals(70, gk.getPlayerPosition().getY());
		gk.setPlayerStatistics(10);
		assertEquals(10, gk.getPlayerStatistics());
	}

}
