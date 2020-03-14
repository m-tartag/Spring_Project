package spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {

        // Create a Spring Container (load config file)

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/applicationContext.xml");

        // retrieve a bean from the spring container

        TrackCoach newCoach = context.getBean("myCoach", TrackCoach.class);
        TrackCoach newCoach2 = context.getBean("myCoach", TrackCoach.class);

        newCoach2.setCheck("No");
        System.out.println(newCoach.getCheck());

        CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
        // call methods on the bean

        System.out.println(newCoach.getDailyWorkout());
        System.out.println(newCoach.getDailyFortune());
        System.out.println(cricketCoach.getDailyWorkout() + " " + cricketCoach.getDailyFortune());
        System.out.println(cricketCoach.getTeam() + " " + cricketCoach.getEmailAddress());


        // close the context

        context.close();
    }
}
