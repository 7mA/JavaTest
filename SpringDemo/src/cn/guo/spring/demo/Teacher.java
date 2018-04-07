package cn.guo.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class Teacher implements Person{
	@Autowired
	private SwimmingService swimmingService;

	@Override
	public String sayHello(){
		return "Hello, I am a teacher.";
	}
	
	public String provideSwimmingCoaching(){
		return swimmingService.provideSwimmingCoachingService();
	}

}
