    package com.learn;

    import com.learn.annotations.MaxNumber;
    import com.learn.annotations.MinNumber;
    import org.springframework.beans.factory.annotation.Autowired;

    import java.util.Random;

    public class NumberGeneratorImpl implements NumberGenerator {

      // == fields ==
      private final Random random = new Random();

      @Autowired
      @MaxNumber
      private int maxNumber;

      @Autowired
      @MinNumber
      private int minNumber;

      // == public methods ==
      @Override
      public int next() {
        return random.nextInt(maxNumber-minNumber)+minNumber;
      }

      @Override
      public int getMaxNumber() {
        return maxNumber;
      }

        @Override
        public int getMinNumber() {
            return minNumber;
        }
    }
