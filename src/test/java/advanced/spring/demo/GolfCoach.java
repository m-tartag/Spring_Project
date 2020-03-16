package advanced.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GolfCoach implements Coach {

    String name, email;

    private FortuneService fortuneService;

    // define a default constructor

    public GolfCoach() {
        System.out.println("Triggered Default Constructor");
    }


//    @Autowired
//    public GolfCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Work on putting. 45 Minutes.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }

    // Getters and Setters

    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Used setFortuneService() method");
        this.fortuneService = fortuneService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
