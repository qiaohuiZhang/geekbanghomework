package week5.homework.service.impl;

import org.springframework.stereotype.Component;
import week5.homework.service.StudentService;

@Component("studentService2")
public class StudentServiceImpl2 implements StudentService {
    public void studentInfoPrint(){
        System.out.println("StudentServiceImpl2 打印了学生信息。。。。。。。。。。。。。");
    }
}
