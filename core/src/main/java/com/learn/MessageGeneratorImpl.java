package com.learn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // == constants ==
    private static String MAIN_MESSAGE = "game.main.message";
    private static String WIN = "game.win";
    private static String LOST = "game.lost";
    private static String INVALID = "game.invalid";
    private static String FIRST_GUESS = "game.firstGuess";
    private static String HIGHER = "game.higher";
    private static String LOWER = "game.lower";
    private static String REMAINING = "game.remaining";
    // == fields ==
    private final Game game;
    private final MessageSource messageSource;

    // == constructor ==
    @Autowired
    public MessageGeneratorImpl(Game game, MessageSource messageSource) {
        this.game = game;
        this.messageSource = messageSource;
    }

    // == init ==
    @PostConstruct
    public void init(){
        log.info("Game = {}", game);
    }

    // == methods ==
    @Override
    public String getMainMessage() {
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());

//        return "Number is between: "
//                +game.getSmallest()
//                +" and "
//                +game.getBiggest()
//                +". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
            return getMessage(WIN, game.getNumber());
        }else if (game.isGameLost()){
            return getMessage(LOST, game.getNumber());
        }else if(!game.isValidNumberRange()){
            return getMessage(INVALID);
        }else if(game.getRemainingGuesses() == game.getGuessCount()){
            return getMessage(FIRST_GUESS);
        }else {
            String direction = getMessage(LOWER);
            if(game.getGuess() < game.getNumber()){
                direction = getMessage(HIGHER);
            }
                return getMessage(REMAINING, direction, game.getRemainingGuesses());
        }
    }

    // == private methods ==
    private String getMessage(String code, Object... args){
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

}
