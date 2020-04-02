package com.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);

    private final static String CONFIG_LOCATION = "beans.xml";

  public static void main(String[] args) {
    log.info("Guess the number game");

    // create context/container

      ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

      NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

      // call method next() to get random num
      int number = numberGenerator.next();

      // log generatred number
      log.info("Number is: {}", number);

      // close context
      context.close();

  }
}
