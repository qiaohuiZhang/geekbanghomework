package week8.homework.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week8.homework.service.TestService;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/testAK")
    public String testAK() {
        testService.test01();
        return "success";
    }
}
