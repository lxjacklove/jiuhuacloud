package com.atjhsc.springcloud.controller;

import com.atjiuhua.springcloud.entities.CommonRusult;
import com.atjiuhua.springcloud.entities.Payment;
import com.atjhsc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")//PostMapping:往数据库写用PostMapping
    public CommonRusult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("********插入结果："+"IOBYGG"+ result);
        if (result > 0) {
            System.out.println(payment.getId());
            return new CommonRusult(200, "插入数据库成功,serverport:"+serverPort, result);
        } else {
            return new CommonRusult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")//GetMapping:获取数据用GetMapping
    public CommonRusult getPaymentById(@PathVariable("id") Long id) {
        System.out.println("11111111111111111111111111111111111");
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("222222222222222222222222222222");
        log.info("********查询结果：" + payment);
        if (payment!=null) {
            return new CommonRusult(200, "查询成功了,serverport:"+serverPort, payment);
        } else {
            return new CommonRusult(444, "没有对应记录，查询ID:"+id, null);
        }
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        List<String> services=discoveryClient.getServices();
        for(String element:services){
            log.info("******element:"+element);
        }

        List<ServiceInstance> instances=discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance:instances) {
          log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
