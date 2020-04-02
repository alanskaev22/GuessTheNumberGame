package com.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    // == Constants ==
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // == fields ==
    @Autowired
    private Game game;

    int guessCount = 10;

    // == init ==
    @PostConstruct
    public void init(){
        log.info("Game = {}", game);
    }
    // == methods ==
    @Override
    public String getMainMessage() {
        return "getmainMessage() Method";
    }

    @Override
    public String getResultMessage() {
        return "getResultMessage() Method";
    }

}
