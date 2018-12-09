package dai.cloud;

import dai.myRibbon.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类(自定义规则的负载均衡算法),从而使配置生效
//注意：这里传入的是 configuration
//注意：这里传入的是 configuration
//注意：这里传入的是 configuration
@RibbonClient(name = "CLOUD-PROVIDER", configuration = MyRuleConfig.class)
public class CloudComsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudComsumerApplication.class, args);
	}
}
