package app.controller;

import app.logic.Arbiter;
import app.logic.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RockPaperScissorsController {

    private Arbiter arbiter;

    public RockPaperScissorsController() {
        arbiter = new Arbiter();
    }

    @PostMapping("/game")
    public Result game(@RequestBody Option option) {
        Result result = null;

        try {
            result = arbiter.calculateResult(option.getOption());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return result;
    }

}