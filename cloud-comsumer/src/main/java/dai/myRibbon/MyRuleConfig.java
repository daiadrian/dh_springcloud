package dai.myRibbon;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRuleConfig {
    @Bean
    public IRule getMyRule(){
        return new MyRule();
    }
}
