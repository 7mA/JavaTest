package cn.guo.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@RestController
@RequestMapping("/user")
@EnableEurekaClient
public class UserService2Application {
	@RequestMapping("/detail")
	public String Detail(){
        return "## Detail information about : User ";
    }

	public static void main(String[] args) {
		SpringApplication.run(UserService2Application.class, args);
	}
}
