        package com.learn.console;

        import com.learn.Game;
import com.learn.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

        @Component
        @Slf4j
        public class ConsoleNumberGuess {

          // == fieds ==
          private final Game game;
          private final MessageGenerator messageGenerator;

          @Autowired
            public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
                this.game = game;
                this.messageGenerator = messageGenerator;
            }

            // == event listener ==
          @EventListener(ContextRefreshedEvent.class)
          public void start() {
            log.info("start() -> Container is ready for use.");

            Scanner scanner = new Scanner((System.in));

            while (true) {
              System.out.println(messageGenerator.getMainMessage());
              System.out.println(messageGenerator.getResultMessage());

              int guess = scanner.nextInt();
              scanner.nextLine();
              game.setGuess(guess);
              game.check();

              if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again? (Y/N)");

                String playAgain = scanner.nextLine().trim();
                if (!playAgain.equalsIgnoreCase("y")) {
                  break;
                }
                game.reset();
              }
            }
          }
        }
