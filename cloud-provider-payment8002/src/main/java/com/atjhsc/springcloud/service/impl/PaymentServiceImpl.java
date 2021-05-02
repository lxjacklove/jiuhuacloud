package com.atjhsc.springcloud.service.impl;

import com.atjhsc.springcloud.dao.PaymentDao;
import com.atjhsc.springcloud.service.PaymentService;
import com.atjiuhua.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    //@Autowired//spring的自动注入
    @Resource//java自带的自动注入
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(@Param("id") Long id) {
        return paymentDao.getPaymentById(id);
    }

}
