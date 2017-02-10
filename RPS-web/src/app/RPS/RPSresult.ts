export class RPSResult {

    constructor(public computerOption : String, public endGame : String) {
    }

    getComputerOption() {
        return this.computerOption;
    }

    getEndGame() {
        return this.endGame;
    }

}