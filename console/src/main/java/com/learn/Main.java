    package com.learn;

    import lombok.extern.slf4j.Slf4j;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
    public class Main {

      public static void main(String[] args) {
    log.info(
        "\n\t\t\t\t\t====================== \n \t\t\t\t\tGUESS THE NUMBER GAME \n\t\t\t\t\t======================");

    SpringApplication.run(Main.class, args);
      }
    }
