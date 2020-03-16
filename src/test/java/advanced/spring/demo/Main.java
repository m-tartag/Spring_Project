package advanced.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from the spring container

        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach theCoach_2 = context.getBean("golfCoach", Coach.class);
        GolfCoach theCoach_3 = context.getBean("golfCoach", GolfCoach.class);

        // call method from the bean

        System.out.println(theCoach.getDailyWorkout());
        System.out.println("- - - - - - - - - - ");
        System.out.println(theCoach_2.getDailyWorkout());
        System.out.println("- - - - - - - - - - ");
        theCoach_3.setName("Michael Richards");
        theCoach_3.setEmail("Kramerica@gmail.com");
        System.out.println(theCoach_3.getName() + " - - - " + theCoach_3.getEmail());
        System.out.println("- - - - - - - - - - ");
        System.out.println(theCoach_3.getDailyFortune());


        // close the context

        context.close();



    }
}
