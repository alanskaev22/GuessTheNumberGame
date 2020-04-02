package com.learn.console;

import com.learn.AppConfig;
import com.learn.MessageGenerator;
import com.learn.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);


  public static void main(String[] args) {
    log.info("Guess the number game");


      // create context/container
      ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      // get number generator bean from context
      NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

      // call method next() to get random num
      int number = numberGenerator.next();

      // log generated number
      log.info("Number is: {}", number);

      // get MessageGenerator bean
      MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
      log.info("getMainMessage() = {}", messageGenerator.getMainMessage());
      log.info("getResultMessage() = {}", messageGenerator.getResultMessage());

      // close context
      context.close();

  }
}
