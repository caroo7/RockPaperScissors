export class RPSResult {

    constructor(private computerOption : String, private endGame : String) {
    }

    getComputerOption() {
        return this.computerOption;
    }

    getEndGame() {
        return this.endGame;
    }

}