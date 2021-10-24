package week5.homework.config;

import org.checkerframework.checker.units.qual.K;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import week5.homework.impl.DemoService;
import week5.homework.impl.Klass;
import week5.homework.impl.School;
import week5.homework.impl.Student;

import java.util.ArrayList;
import java.util.List;

//标记为配置类
//启动配置属性
//保证DemoService接口在
//@ConditionalOnClass(DemoService.class)
//@ConditionalOnProperty(prefix = "demo",value = "enabled",matchIfMissing = true)
@EnableConfigurationProperties(DemoProperties.class)
@Configuration
public class DemoConfiguration {

    @Autowired
    private DemoProperties demoProperties;
    @Autowired
    private Student student100;
    @Autowired
    private Student student123;
    @Autowired
    private Klass klass;
    @Autowired
    private School school;


//    @ConditionalOnMissingBean(DemoService.class)
    @Bean
    public  DemoService demoService(){
        DemoService service = new DemoService(student100,student123,school,klass);
        service.setName(demoProperties.getName());
        service.setStudent100(student100);
        return service;
    }

    @Bean("student100")
    public Student demoStudent100(){
        Student student100 = new Student();
        student100.setName("KK100");
        student100.setId(100);
        return student100;
    }

    @Bean("student123")
    public Student demoStudent123(){
        Student student100 = new Student();
        student100.setName("KK123");
        student100.setId(123);
        return student100;
    }

    @Bean
    public Klass demoKlass(){
        Klass klass = new Klass();
        List<Student> list = new ArrayList<>();
        list.add(student100);
        list.add(student123);
        klass.setStudents(list);
        return klass;
    }

    @Bean
    public School demoSchool(){
        return new School();
    }
}
