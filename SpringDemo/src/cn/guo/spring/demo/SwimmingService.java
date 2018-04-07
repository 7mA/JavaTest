package cn.guo.spring.demo;

import org.springframework.stereotype.Service;

@Service
public class SwimmingService {
	public SwimmingService(){
		System.out.println("Default SwimmingService Constructor is called.");
	}
	public String provideSwimmingCoachingService(){
		return "Swimming coaching Service provided.";
	}
}
