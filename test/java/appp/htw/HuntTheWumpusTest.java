package java.appp.htw;


import org.junit.Assert;
import org.junit.Test;

public class HuntTheWumpusTest {

    @Test
    public void testMove() {
        WumpusGame game = new WumpusGame();
        game.connect(4,5,"E");
        game.getPlayerRoom("4");
        game.east();
        Assert.assertEquals(5, game.getPlayerRoom());
    }
}
