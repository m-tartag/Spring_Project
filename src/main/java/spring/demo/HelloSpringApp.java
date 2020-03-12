package spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {

        // Create a Spring Container (load config file)

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/applicationContext.xml");

        // retrieve a bean from the spring container

        Coach newCoach = context.getBean("myCoach", Coach.class);
        Coach newCoach_2 = context.getBean("myCoach2", Coach.class);

        // call methods on the bean

        System.out.println(newCoach.getDailyWorkout() + " " + newCoach_2.getDailyWorkout());

        // close the context

        context.close();
    }
}
