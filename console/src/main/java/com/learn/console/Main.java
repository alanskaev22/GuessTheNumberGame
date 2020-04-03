    package com.learn.console;

    import com.learn.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@Slf4j
    public class Main {

      public static void main(String[] args) {
    log.info(
        "\n\t\t\t\t\t====================== \n \t\t\t\t\tGUESS THE NUMBER GAME \n\t\t\t\t\t======================");

        // create context/container
        ConfigurableApplicationContext context =
            new AnnotationConfigApplicationContext(GameConfig.class);

        // close context
        context.close();
      }
    }
