package spring.demo;

public class CricketCoach implements Coach {

    private String emailAddress;
    private String team;

    private FortuneService fortuneService;

    // Create and no-arg constructor

    public CricketCoach() {
        System.out.println("CricketCoach: No-Arg Constructor");
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: Setter Constructor");
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }
}
