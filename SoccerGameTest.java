package model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

import java.awt.Point;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import model.players.Goalkeeper;
import model.players.PlayerCollection;
import model.players.PlayerFactory;
import model.players.Striker;

class SoccerGameTest {

	@Test
	void testSoccerGame() {
		SoccerGame sg = new SoccerGame();
		assertEquals(60, sg.getTimeRemaining(), "TimeRemaining should be 60");
		assertEquals(0, sg.getGoal(), "Goal should be 0");
		assertEquals(false, sg.isPaused(), "isPaused should return false");
		assertEquals(false, sg.isOver(), "isOver should return false");
	}
	
	@Test
	void startGame() {
		SoccerGame sg1 = new SoccerGame();
		sg1.setTimeRemaining(0);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {}
		assertEquals(true, sg1.isOver());
	}

	@Test
	void testGetTimeRemaining() {
		SoccerGame sg = new SoccerGame();
		assertEquals(60, sg.getTimeRemaining(), "TimeRemaining should be 60");
	}

	@Test
	void testSetTimeRemaining() {
		SoccerGame sg = new SoccerGame();
		sg.setTimeRemaining(100);
		assertEquals(100, sg.getTimeRemaining(), "TimeRemaining should be 100");
	}

	@Test
	void testGetGoal() {
		SoccerGame sg = new SoccerGame();
		assertEquals(0, sg.getGoal(), "Goal should be 0");
	}

	@Test
	void testSetGoal() {
		SoccerGame sg = new SoccerGame();
		sg.setGoal(100);
		assertEquals(100, sg.getGoal(), "Goal should be 100");
	}
	@Test
	void testIsPaused() {
		SoccerGame sg = new SoccerGame();
		assertEquals(false, sg.isPaused(), "isPaused should return false");
	}

	@Test
	void testSetPaused() {
		SoccerGame sg = new SoccerGame();
		sg.setPaused(true);
		assertEquals(true, sg.isPaused(), "isPaused should return true");
	}

	@Test
	void testIsOver() {
		SoccerGame sg = new SoccerGame();
		assertEquals(false, sg.isOver(), "isOver should return false");
	}

	@Test
	void testSetOver() {
		SoccerGame sg = new SoccerGame();
		sg.setOver(true);
		assertEquals(true, sg.isOver(), "isOver should return true");
	}

	@Test
	void testGetGamePlayers() {
		SoccerGame sg = new SoccerGame();
		assertEquals(2, sg.getGamePlayers().getList().size(), "It should return a list with size 2");
	}

	@Test
	void testAutomateGoalkeeper() {
		SoccerGame sg = new SoccerGame();
		Goalkeeper goalkeeper = (Goalkeeper) sg.getGamePlayers().get("Goalkeeper");
		Point op  = goalkeeper.getPlayerPosition();
		goalkeeper.moveRandomly();
		if (goalkeeper.getMovementStep() == 0) {
			assertEquals(op.getX(), goalkeeper.getPlayerPosition().getX());
		}
		else {
			assertNotEquals(op.getX(), goalkeeper.getPlayerPosition().getX());
		}
		SoccerBall.getSoccerBall().setPosition(new Point(0, 100));
		int os = goalkeeper.getPlayerStatistics();
		sg.automateGoalkeeper();
		assertNotEquals(os, goalkeeper.getPlayerStatistics(), "Origin statistics and statistics after automated shoud not be the same");
	}

	@Test
	void testIsScored() {
		SoccerGame sg = new SoccerGame();
		assertEquals(sg.isScored(), SoccerBall.getSoccerBall().inGate(), "These value should be the same");
	}

	@Test
	void testGetActivePlayer() {
		SoccerGame sg = new SoccerGame();
		assertEquals(sg.getActivePlayer(),sg.getGamePlayers().get("Striker"), "Two object should be the same");
	}

}
