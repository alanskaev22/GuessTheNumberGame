package com.learn.config;


import com.learn.annotations.GuessCount;
import com.learn.annotations.MaxNumber;
import com.learn.annotations.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "com.learn")
public class GameConfig {

    // == fields ==
    @Value("${game.maxNumber:100}")   // 50 is the default value if property cannot be found
    private int maxNumber;

    @Value("${game.minNumber:0}")
    private int minNumber;

    @Value("${game.guessCount:10}")
    private int guessCount;


    // == beans ==
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }


}
