package advanced.spring.demo;

import org.springframework.stereotype.Component;

@Component
public class GolfCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Work on putting. 45 Minutes.";
    }
}
