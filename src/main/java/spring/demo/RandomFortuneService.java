package spring.demo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

    String[] fortuneArray = {
            "Be careful what you wish for.",
            "Tread lightly.",
            "Good news is imminent"
    };

    // Create and random number generator
    Random newRandom = new Random();



    @Override
    public String getDailyFortune() {
        int index = newRandom.nextInt(fortuneArray.length);
        return fortuneArray[index];
    }
}
