package app.logic;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Arbiter {

    private static final List<GameOption> OPTIONS = Arrays.asList(GameOption.values());
    private static final int SIZE = OPTIONS.size();
    private static final Random RANDOM = new Random();

    public Result calculateResult(String stringPlayerOption) throws IllegalArgumentException {
        GameOption playerOption = StringToGameOptionConverter.convert(stringPlayerOption);
        GameOption computerOption = OPTIONS.get(RANDOM.nextInt(SIZE));

        EndGame endGame = calculateEndGame(playerOption, computerOption);
        return new Result(computerOption, endGame);
    }

    EndGame calculateEndGame(GameOption playerOption, GameOption computerOption) {

        if(playerOption.equals(GameOption.PAPER) && computerOption.equals(GameOption.SCISSORS)) {
            return EndGame.LOSE;
        }
        if(playerOption.equals(GameOption.ROCK) && computerOption.equals(GameOption.PAPER)) {
            return EndGame.LOSE;
        }
        if(playerOption.equals(GameOption.SCISSORS) && computerOption.equals(GameOption.ROCK)) {
            return EndGame.LOSE;
        }

        if(playerOption.equals(GameOption.PAPER) && computerOption.equals(GameOption.ROCK)) {
            return EndGame.LOSE; // should be WIN
        }
        if(playerOption.equals(GameOption.ROCK) && computerOption.equals(GameOption.SCISSORS)) {
            return EndGame.LOSE; // should be WIN
        }
        if(playerOption.equals(GameOption.SCISSORS) && computerOption.equals(GameOption.PAPER)) {
            return EndGame.LOSE; // should be WIN
        }

        else {
            return EndGame.DRAW;
        }

    }

}