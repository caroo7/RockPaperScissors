package app.logic;

import java.io.Serializable;

public class Result implements Serializable {

    private GameOption computerOption;

    private EndGame endGame;

    public Result(GameOption option, EndGame endGame) {
        this.computerOption = option;
        this.endGame = endGame;
    }

    public GameOption getComputerOption() {
        return computerOption;
    }

    public EndGame getEndGame() {
        return endGame;
    }

}