        package com.learn.console;

        import com.learn.Game;
        import com.learn.MessageGenerator;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.event.ContextRefreshedEvent;
        import org.springframework.context.event.EventListener;
        import org.springframework.stereotype.Component;

        import java.util.Scanner;

        @Component
        public class ConsoleNumberGuess {

          // == constants ==
          private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

          // == fieds ==
          @Autowired private Game game;

          @Autowired private MessageGenerator messageGenerator;

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
