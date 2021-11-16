package week8.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import week8.homework.entity.Student;
import week8.homework.entity.Teacher;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @Transactional(transactionManager = "xatx", propagation = Propagation.REQUIRED, rollbackFor = { java.lang.RuntimeException.class })
    public Map<String, Object> test01() {
        LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
        Student student =new Student();
        student.setName("狗娃");
        student.setAge(18);
        studentService.saveStudent(student);

//        System.out.println(1/0); 测试期间异常中断事务是否回滚

        Teacher teacher=new Teacher();
        teacher.setName("狗娃的老师");
        teacher.setAge(28);
        teacherService.saveTeacher(teacher);

        resultMap.put("state","success");
        resultMap.put("message","分布式事务同步成功");
        return resultMap;
    }
}
