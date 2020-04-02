package com.learn.config;


import com.learn.GuessCount;
import com.learn.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    // == fields ==
    private int maxNumber = 25;
    private int guessCount = 9;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

}
