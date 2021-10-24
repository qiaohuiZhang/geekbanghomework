package week5.homework.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week5.homework.impl.DemoService;


@SpringBootApplication
@RestController
public class DemoServiceLoaning {

    @Autowired
    private DemoService demoService;

    @RequestMapping("testRun")
    public void testRun(){
        demoService.demoRun();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoServiceLoaning.class, args);
    }

}
