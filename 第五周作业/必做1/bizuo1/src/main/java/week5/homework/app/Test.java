package week5.homework.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week5.homework.service.ClassService;

public class Test {
    
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassService classService = (ClassService) context.getBean("classService");

        //方式一：在XML配置方式注入
        classService.showStudents1();

        //方式二：component 和 Resource 等注解方式方式注入
        classService.showStudents2();

        //方式三：根据构造方法自动装配
        classService.showStudents3();
    }
}
