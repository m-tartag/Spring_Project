package advanced.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from the spring container

        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach theCoach_2 = context.getBean("golfCoach", Coach.class);

        // call method from the bean

        System.out.println(theCoach.getDailyWorkout());
        System.out.println("- - - - - - - - - - ");
        System.out.println(theCoach_2.getDailyWorkout());



        // close the context

        context.close();



    }
}
