import { Component } from '@angular/core'
import { PostService } from './RPS/RPS.post.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [PostService]
})
export class AppComponent {
  title = 'Rock-Paper-Scissors! game';
  
  imagePath : String = "";
  endOfGame : String = "";
  computerImagePath : String = "";

  constructor(private postService : PostService) {
  }

  rockAction() {
     this.action("rock");
  }

  paperAction() {
     this.action("paper");
  }

  scissorsAction() {
     this.action("scissors");
  }

  action(option : String) {
     this.imagePath = "./assets/img/" + option + ".png"
     this.postService.createPost(option.toUpperCase()).subscribe(result => {
       this.chooseComputerImage(result.computerOption);
       this.creteAppropriateResultMessage(result.endGame);
     });
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

  creteAppropriateResultMessage(endOfGame : String) {
    if(endOfGame == "WIN") {
        this.endOfGame = "You win :)"
    }
    if(endOfGame == "LOSE") {
        this.endOfGame = "You lose :("
    }
    if(endOfGame == "DRAW") {
        this.endOfGame = "We have a draw."
    } 
  }

}