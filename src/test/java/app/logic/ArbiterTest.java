package app.logic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArbiterTest {

    @DataProvider(name = "loseDataProvider")
    private Object[][] loseDataProvider(){
        return new Object[][] {{GameOption.PAPER, GameOption.SCISSORS}, {GameOption.ROCK, GameOption.PAPER}, {GameOption.SCISSORS, GameOption.ROCK}};
    }

    @Test(dataProvider = "loseDataProvider")
    public void playerShouldLoseTest(GameOption playerOption, GameOption computerOption) {
        Arbiter arbiter = new Arbiter();

        EndGame endGame = arbiter.calculateEndGame(playerOption, computerOption);

        assertEquals(endGame, EndGame.LOSE);
    }

    @DataProvider(name = "winDataProvider")
    private Object[][] winDataProvider(){
        return new Object[][] {{GameOption.SCISSORS, GameOption.PAPER}, {GameOption.PAPER, GameOption.ROCK}, {GameOption.ROCK, GameOption.SCISSORS}};
    }

    @Test(dataProvider = "winDataProvider")
    public void playerShouldWinTest(GameOption playerOption, GameOption computerOption) {
        Arbiter arbiter = new Arbiter();

        EndGame endGame = arbiter.calculateEndGame(playerOption, computerOption);

        assertEquals(endGame, EndGame.WIN);
    }

    @DataProvider(name = "drawDataProvider")
    private Object[][] drawDataProvider(){
        return new Object[][] {{GameOption.SCISSORS, GameOption.SCISSORS}, {GameOption.PAPER, GameOption.PAPER}, {GameOption.ROCK, GameOption.ROCK}};
    }

    @Test(dataProvider = "drawDataProvider")
    public void shouldBeADrawTest(GameOption playerOption, GameOption computerOption) {
        Arbiter arbiter = new Arbiter();

        EndGame endGame = arbiter.calculateEndGame(playerOption, computerOption);

        assertEquals(endGame, EndGame.DRAW);
    }

}