package spring.demo;

public class BasketballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Dribbling 101";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
