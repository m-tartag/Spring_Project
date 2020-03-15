package advanced.spring.demo;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Work on backhand. 30 Minutes.";
    }
}
