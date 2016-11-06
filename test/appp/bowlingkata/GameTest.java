package appp.bowlingkata;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
    Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void scoreNoThrows() {
        assertEquals(0, game.score());
    }

    @Test
    public void twoThrowsNoMark() {
        game.add(5);
        game.add(4);
        assertEquals(9, game.score());
        assertEquals(2, game.currentFrame());
    }

    @Test
    public void fourThrowsNoMark() {
        game.add(5);
        game.add(4);

        game.add(7);
        game.add(2);
        assertEquals(18, game.score());
        assertEquals(9, game.scoreForFrame(1));
        assertEquals(18, game.scoreForFrame(2));
        assertEquals(3, game.currentFrame());
    }

    @Test
    public void simpleSpare() {
        game.add(3);
        game.add(7);
        game.add(3);
        assertEquals(13, game.scoreForFrame(1));
    }

    @Test
    public void simpleFrameAfterSpare() {
        game.add(3);
        game.add(7);
        game.add(3);
        game.add(2);
        assertEquals(13, game.scoreForFrame(1));
        assertEquals(18, game.scoreForFrame(2));
    }

    @Test
    public void simpleStrike() {
        game.add(10);
        game.add(3);
        game.add(6);

        assertEquals(19, game.scoreForFrame(1));
        assertEquals(28, game.score());
        assertEquals(3, game.currentFrame());
    }

    @Test
    public void perfectGame() {
        for (int i = 0; i < 12; i++) {
            game.add(10);
        }
        assertEquals(300, game.score());
        assertEquals(11, game.currentFrame());
    }

    @Test
    public void endOfArray() {
        for (int i = 0; i < 9; i++) {
            game.add(0);
            game.add(0);
        }
        game.add(2);
        game.add(8); // 10th frame spare
        game.add(10); // Strike in last position of array
        assertEquals(20, game.score());
    }

    @Test
    public void sampleGame() {
        game.add(1);
        game.add(4);
        game.add(4);
        game.add(5);
        game.add(6);
        game.add(4);
        game.add(5);
        game.add(5);
        game.add(10);
        game.add(0);
        game.add(1);
        game.add(7);
        game.add(3);
        game.add(6);
        game.add(4);
        game.add(10);
        game.add(2);
        game.add(8);
        game.add(6);
        assertEquals(133, game.score());
    }

    @Test
    public void heartBreak() {
        for (int i = 0; i < 11; i++) {
            game.add(10);
        }
        game.add(9);
        assertEquals(299, game.score());
    }

    @Test
    public void tenthFrameSpare() {
        for (int i = 0; i < 9; i++) {
            game.add(10);
        }
        game.add(9);
        game.add(1);
        game.add(1);
        assertEquals(270, game.score());
    }

}
