package spring.demo;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;
    private String check = "Yes";

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k.";
    }

    @Override
    public String getDailyFortune() {
        return "Track Fortune: " + fortuneService.getDailyFortune();
    }
}
