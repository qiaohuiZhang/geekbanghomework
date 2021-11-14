package week8.homework.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week8.homework.service.OrderService;

import javax.annotation.Resource;

@RestController
public class ShardingDemoService {

    @Resource
    private OrderService orderService;

    @RequestMapping("/addOrders")
    public String addOrders() {
        orderService.inserOrder();
        return "success";
    }

    @RequestMapping("/getOrders")
    public String getOrders() {
        orderService.getOrders();
        return "success";
    }



}
