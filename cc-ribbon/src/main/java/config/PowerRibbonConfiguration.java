package config;

import com.cc.ribbon.config.MyRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * D-POWER 负载均衡策略
 *
 * @author YL.huang
 * @date 03/09/2020
 */
@Configuration
public class PowerRibbonConfiguration {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }

}
