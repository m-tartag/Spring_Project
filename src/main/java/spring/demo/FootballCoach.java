package spring.demo;

public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Tackling Drills. 20 Minutes";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
