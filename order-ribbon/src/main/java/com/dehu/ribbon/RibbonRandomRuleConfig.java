package com.dehu.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注意：不能在@SpringBootApplication注解的@CompentScan扫描到的地方写这个配置类
 * 否则自定义的配置类就会被所有的RibbonClients所共享，一般情况下不建议这么使用，推荐yml的方式
 */
@Configuration
public class RibbonRandomRuleConfig {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }

}
