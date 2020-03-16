package advanced.spring.demo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getDailyFortune() {
        String[] fortunes = {
                "Today is your lucky day!",
                "Be careful what you wish for",
                "Good things are coming",
                "Tread lightly",
                "Lucky Numbers: 3, 4, 5, 6, 7"
        };

        int random = (int) (Math.random() * fortunes.length);

        return fortunes[random];

    }

}
