package com.dehu.sentinel.controller;


import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class HelloController {

    // 定义被流控的资源-hello
    private static final String RESOURCE_NAME = "hello";

    private static final String USER_RESOURCE_NAME = "user";

    private static final String DEGRADE_RESOURCE_NAME = "degrade";

    // 进行sentinel流控
    @RequestMapping(value = "/hello")
    public String hello() {

        Entry entry = null;
        try {
            // 1.sentinel针对资源进行限制的
            entry = SphU.entry(RESOURCE_NAME);
            // 被保护的业务逻辑
            String str = "hello world";
            log.info("=====" + str + "=====");
            return str;
        } catch (BlockException e1) {
            // 资源访问阻止，被限流或被降级
            // 进行相应的处理操作
            log.info("block!");
            return "被流控了！";
        } catch (Exception ex) {
            // 若需要配置降级规则，需要通过这种方式记录业务异常
            Tracer.traceEntry(ex, entry);
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return null;
    }


    /**
     * 定义规则
     *
     * spring 的初始化方法
     */
    @PostConstruct  //
    private static void initFlowRules(){

        // 流控规则
        List<FlowRule> rules = new ArrayList<>();

        // 流控
        FlowRule rule = new FlowRule();
        // 为哪个资源进行流控
        rule.setResource(RESOURCE_NAME);
        // 设置流控规则 QPS
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置受保护的资源阈值
        // Set limit QPS to 20.
        rule.setCount(1);
        rules.add(rule);



        // // 通过@SentinelResource来定义资源并配置降级和流控的处理方法
        // FlowRule rule2 = new FlowRule();
        // //设置受保护的资源
        // rule2.setResource(USER_RESOURCE_NAME);
        // // 设置流控规则 QPS
        // rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // // 设置受保护的资源阈值
        // // Set limit QPS to 20.
        // rule2.setCount(1);
        //
        // rules.add(rule2);

        // 加载配置好的规则
        FlowRuleManager.loadRules(rules);
    }

    /**
     * 初始化
     */
    @PostConstruct
    public void initDegradeRule() {

    }


}
