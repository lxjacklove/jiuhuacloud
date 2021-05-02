package com.atjhsc.springcloud.controller;

import com.atjhsc.springcloud.service.PaymentService;
import com.atjiuhua.springcloud.entities.CommonRusult;
import com.atjiuhua.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")//PostMapping:往数据库写用PostMapping
    public CommonRusult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("********插入结果："+"IOBYGG"+ result);
        if (result > 0) {
            System.out.println(payment.getId());
            return new CommonRusult(200, "插入数据库成功", result);
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
            return new CommonRusult(200, "查询成功了", payment);
        } else {
            return new CommonRusult(444, "没有对应记录，查询ID:"+id, null);
        }
    }
}
