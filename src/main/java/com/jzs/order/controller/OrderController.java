package com.jzs.order.controller;

import com.jzs.order.dto.OrderProtos;
import com.jzs.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.SpanAccessor;
import org.springframework.cloud.sleuth.annotation.ContinueSpan;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.trace.DefaultTracer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private SpanAccessor spanAccessor;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/order/{id}")
    @HystrixCommand
    public OrderProtos.OrderDTO queryUserByUid(@PathVariable("id") Integer id) {
        log.info("getTraceId:{}", Span.idToHex(spanAccessor.getCurrentSpan().getTraceId()));
        log.info("id:{}", id);
        return orderService.queryOrderById(id);
    }

    @GetMapping("/")
    @HystrixCommand
    public String home() {

//        stringRedisTemplate.opsForSet("a","a").;

        DefaultTracer trace = (DefaultTracer) spanAccessor;
        Span redisSpan = trace.createSpan("redis", trace.getCurrentSpan());
//        trace.continueSpan(redisSpan);

        String value = null;
        try {
            redisSpan.logEvent("redis start");
            for (int i = 0; i < 3; i++) {
                trace.addTag("key " + i, String.valueOf(i));
                value = stringRedisTemplate.opsForValue().get("home");
            }
//            trace.close(redisSpan);
            redisSpan.logEvent("redis end");
        } finally {
            trace.close(redisSpan);
        }

        testNewSpan();
        testMethod4();

        log.info("home :{}", value);

        return value;
        //stringRedisTemplate.opsForSet().add("key","value");
        //return "home";
    }

    @GetMapping("/n")
    @NewSpan
    public void testNewSpan() {
        log.info("NewSpan");
    }

    @GetMapping("/m")
    @NewSpan("customNameOnTestMethod4")
    public void testMethod4(){
        ContinueSpan();
        log.info("testMethod4");
    }

    @ContinueSpan(log = "log ddddd")
    public void ContinueSpan(){
        log.info("ContinueSpan");
    }
}
