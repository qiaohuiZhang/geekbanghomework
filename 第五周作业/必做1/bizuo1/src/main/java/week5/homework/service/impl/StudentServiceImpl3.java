package week5.homework.service.impl;

import org.springframework.stereotype.Component;
import week5.homework.service.StudentService;

@Component("studentService3")
public class StudentServiceImpl3 implements StudentService {
    public void studentInfoPrint(){
        System.out.println("StudentServiceImpl3 打印了学生信息。。。。。。。。。。。。。");
    }
}
