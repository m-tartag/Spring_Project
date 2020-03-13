package spring.demo;

public class BaseballCoach implements Coach {

    //define a private attribute for the dependency
    private FortuneService fortuneService;

    //define a constructor for dependency injection
    public BaseballCoach() {

    }

    public BaseballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice.";
    }

    @Override
    public String getDailyFortune() {

        // use my fortuneService to get a fortune
        return fortuneService.getDailyFortune();
    }
}
