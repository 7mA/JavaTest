package cn.guo.spring.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		Teacher person = context.getBean(Teacher.class);
	    System.out.println(person.provideSwimmingCoaching());
	    Teacher personB = context.getBean(Teacher.class);
	    if (person == personB){
	      System.out.println("person and personB point to the same object...");
	    }else{
	      System.out.println("person and personB point to the different object...");
	    }
	    System.out.println("person object address" + person);
	    System.out.println("personB object address" + personB);
		context.close();
	}
}
