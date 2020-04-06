package com.learn.controller;

import com.learn.service.GameService;
import com.learn.util.AttributeNames;
import com.learn.util.Mappings;
import com.learn.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GameController {

    // == private fields ==
    private final GameService gameService;

    // == constructor ==
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(Mappings.PLAY)
    public String play(Model model) {
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("Model = {}", model);

        if(gameService.isGameOVer()){
            return ViewNames.GAME_OVER;
        }
        return ViewNames.PLAY;
    }

    @PostMapping(Mappings.PLAY)
    public String processMessage(@RequestParam int guess){
        log.info("Guess = {}", guess);

        gameService.checkGuess(guess);
        return Mappings.REDIRECT_PLAY;
    }

    @GetMapping(Mappings.RESTART)
    public String restart(){
        gameService.reset();
        return Mappings.REDIRECT_PLAY;
    }
}
