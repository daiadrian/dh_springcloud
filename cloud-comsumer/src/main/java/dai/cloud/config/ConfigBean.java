package dai.cloud.config;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    //加上这个注解开启Ribbon的负载均衡机制,默认是轮询方式
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule getMyRule(){
        //轮询算法
        new RoundRobinRule();
        //根据平均响应时间计算服务的权重。
        // 统计信息不足时会按照轮询，统计信息足够会按照响应的时间选择服务
        new WeightedResponseTimeRule();
        //正常时按照轮询选择服务
        // 若过程中有服务出现故障，在轮询一定次数后依然故障，则会跳过故障的服务继续轮询
        new RetryRule();
        //随机算法
        return new RandomRule();
    }

}
