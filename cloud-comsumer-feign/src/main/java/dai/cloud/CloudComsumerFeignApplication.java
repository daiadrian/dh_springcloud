package dai.cloud;

import dai.cloud.config.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "dai.cloud", defaultConfiguration = ConfigBean.class)
@ComponentScan(value = "dai.cloud")
public class CloudComsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudComsumerFeignApplication.class, args);
	}
}
