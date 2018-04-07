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
public class UserServiceApplication {
	@RequestMapping("/detail")   //单纯的地址映射，对应端口下的/user/detail/会调用下面这个函数
    public String Detail(){
        return "## Detail information about : User ";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
