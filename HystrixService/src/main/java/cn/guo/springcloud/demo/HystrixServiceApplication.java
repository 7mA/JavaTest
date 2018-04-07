package cn.guo.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableEurekaClient
@EnableTurbine
@EnableHystrixDashboard
public class HystrixServiceApplication {
	@RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }

	public static void main(String[] args) {
		SpringApplication.run(HystrixServiceApplication.class, args);
	}
}
