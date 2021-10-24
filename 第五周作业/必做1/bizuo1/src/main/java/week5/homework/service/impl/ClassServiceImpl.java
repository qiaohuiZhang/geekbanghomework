package week5.homework.service.impl;

import org.checkerframework.checker.units.qual.C;
import week5.homework.service.ClassService;
import week5.homework.service.StudentService;

import javax.annotation.Resource;

public class ClassServiceImpl implements ClassService {

    private StudentService studentService1; //方式一：XML配合方式注入

    @Resource(name="studentService2")
    private StudentService studentService2; //方式二：component 和 Resource 等注解方式方式注入

    private StudentService studentService3; //方式三：根据构造方法自动装配


    public ClassServiceImpl(){
    }

    public ClassServiceImpl(StudentService studentService3){
        this.studentService3 = studentService3;
    }

    public void showStudents1(){
        studentService1.studentInfoPrint();
    }

    public void showStudents2(){
        studentService2.studentInfoPrint();
    }

    public void showStudents3(){
        studentService3.studentInfoPrint();
    }


    public StudentService getStudentService1() {
        return studentService1;
    }

    public void setStudentService1(StudentService studentService1) {
        this.studentService1 = studentService1;
    }
}
