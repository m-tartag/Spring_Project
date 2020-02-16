package spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {

        // load the spring config file

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/applicationContext.xml");

        // retrieve a bean from the spring container

        Coach coachThree = context.getBean("myCoach", Coach.class);

        // call methods on the bean

        System.out.println(coachThree.getDailyWorkout());

        // close the context

        context.close();
    }
}
