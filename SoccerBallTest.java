package model;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class SoccerBallTest {
	
	@BeforeEach
	void setUp() {
		SoccerBall.getSoccerBall().resetSoccerBall();
	}
	
	@Test
	void testGetSoccerBall() {
		assertEquals(Color.white, SoccerBall.getSoccerBall().getColor(),"Should return color white");
	}

	@Test
	void testMoveBall() {
		SoccerBall.getSoccerBall().resetSoccerBall();
		SoccerBall.getSoccerBall().moveBall(60, 5.0, 0.05);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {}
		assertEquals(480, SoccerBall.getSoccerBall().getPosition().getX(),"Should return stop at correct X");
		assertEquals(259, SoccerBall.getSoccerBall().getPosition().getY(),"Should return stop at correct Y");
	}

	@Test
	void testMoveBallY_1() {
		SoccerBall.getSoccerBall().moveBallY(0);
		assertEquals(480, SoccerBall.getSoccerBall().getPosition().getX(),"X should not change");
		assertEquals(500, SoccerBall.getSoccerBall().getPosition().getY(),"Y should not change");
	}

	@Test
	void testMoveBallY_2() {
		SoccerBall.getSoccerBall().moveBallY(50);
		assertEquals(480, SoccerBall.getSoccerBall().getPosition().getX(),"X should not change");
		assertEquals(450, SoccerBall.getSoccerBall().getPosition().getY(),"Y should be 450");
	}

	@Test
	void testMoveBallY_3() {
		SoccerBall.getSoccerBall().moveBallY(-10);
		assertEquals(480, SoccerBall.getSoccerBall().getPosition().getX(),"X should not change");
		assertEquals(500, SoccerBall.getSoccerBall().getPosition().getY(),"Y should not change");
	}

	@Test
	void testMoveBallY_4() {
		SoccerBall.getSoccerBall().moveBallY(-5);
		assertEquals(480, SoccerBall.getSoccerBall().getPosition().getX(),"X should not change");
		assertEquals(505, SoccerBall.getSoccerBall().getPosition().getY(),"Y should be 505");
	}

	@Test
	void testResetSoccerBall() {
		SoccerBall.getSoccerBall().setVelocity(60.0);
		SoccerBall.getSoccerBall().setPosition(new Point(300, 300));
		SoccerBall.getSoccerBall().resetSoccerBall();
		assertEquals(480, SoccerBall.getSoccerBall().getPosition().getX(),"X should be 480");
		assertEquals(500, SoccerBall.getSoccerBall().getPosition().getY(),"Y should be 500");
	}

	@Test
	void testOnGoalkeeperSide_1() {
		SoccerBall.getSoccerBall().setPosition(new Point(300, 200));
		assertEquals(false, SoccerBall.getSoccerBall().onGoalkeeperSide(),"It should return false");
	}

	@Test
	void testOnGoalkeeperSide_2() {
		SoccerBall.getSoccerBall().setPosition(new Point(300, 190));
		assertEquals(true, SoccerBall.getSoccerBall().onGoalkeeperSide(),"It should return true");
	}

	@Test
	void testInGate_1() {
		SoccerBall.getSoccerBall().setPosition(new Point(100, 100));
		assertEquals(false, SoccerBall.getSoccerBall().inGate(),"It should return false");
	}

	@Test
	void testInGate_2() {
		SoccerBall.getSoccerBall().setPosition(new Point(300, 100));
		assertEquals(false, SoccerBall.getSoccerBall().inGate(),"It should return false");
	}

	@Test
	void testInGate_3() {
		SoccerBall.getSoccerBall().setPosition(new Point(100, 50));
		assertEquals(false, SoccerBall.getSoccerBall().inGate(),"It should return false");
	}

	@Test
	void testInGate_4() {
		SoccerBall.getSoccerBall().setPosition(new Point(300, 50));
		assertEquals(true, SoccerBall.getSoccerBall().inGate(),"It should return true");
	}

	@Test
	void testGetVelocity() {
		SoccerBall.getSoccerBall().resetSoccerBall();
		assertEquals(0.0, SoccerBall.getSoccerBall().getVelocity(),"It should return 0.0");
	}

	@Test
	void testSetVelocity() {
		SoccerBall.getSoccerBall().setVelocity(60.0);
		assertEquals(60.0, SoccerBall.getSoccerBall().getVelocity(),"It should return 60.0");
	}

	@Test
	void testGetPosition() {
		SoccerBall.getSoccerBall().resetSoccerBall();
		assertEquals(480, SoccerBall.getSoccerBall().getPosition().getX(),"X should be 480");
		assertEquals(500, SoccerBall.getSoccerBall().getPosition().getY(),"Y should be 500");;
	}

	@Test
	void testsetPosition() {
		SoccerBall.getSoccerBall().setPosition(new Point(300, 300));
		assertEquals(300, SoccerBall.getSoccerBall().getPosition().getX(),"X should be 300");
		assertEquals(300, SoccerBall.getSoccerBall().getPosition().getY(),"Y should be 300");;
	}

	@Test
	void testGetColor() {
		SoccerBall.getSoccerBall().resetSoccerBall();
		assertEquals(Color.white, SoccerBall.getSoccerBall().getColor(),"It should return white");
	}

}
