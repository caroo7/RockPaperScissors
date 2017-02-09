import { Component } from '@angular/core'
import { RPSService } from './RPS/RPS.service'
import { RPSResult } from './RPS/RPSresult'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [RPSService]
})
export class AppComponent {
  title = 'Rock-Paper-Scissors! game';
  
  imagePath : String = "";
  
  rpsResult : RPSResult;
  endOfGame : String = "";

  computerImagePath : String = "";

  constructor(rpsService : RPSService) {
    this.rpsResult = rpsService.retrieveResult();
    this.endOfGame = this.rpsResult.getEndGame().toLowerCase();
  }

  rockAction() {
     this.imagePath = "./assets/img/rock.png";
     this.chooseComputerImage(this.rpsResult.getComputerOption())
  }

  paperAction() {
     this.imagePath = "./assets/img/paper.png";
     this.chooseComputerImage(this.rpsResult.getComputerOption())
  }

  scissorsAction() {
     this.imagePath = "./assets/img/scissors.png";
     this.chooseComputerImage(this.rpsResult.getComputerOption())
  }


  chooseComputerImage(computerOption : String) {
    if(computerOption == "ROCK") {
        this.computerImagePath = "./assets/img/rock.png";
    }
    if(computerOption == "PAPER") {
        this.computerImagePath = "./assets/img/paper.png";
    }
    if(computerOption == "SCISSORS") {
        this.computerImagePath = "./assets/img/scissors.png";
    } 
  }

  
}