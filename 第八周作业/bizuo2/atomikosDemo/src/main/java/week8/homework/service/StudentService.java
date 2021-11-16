package week8.homework.service;

import org.springframework.stereotype.Service;
import week8.homework.entity.Student;
import week8.homework.mapper.StudentMapper;

import javax.annotation.Resource;

@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    public Boolean saveStudent(Student student) {
        int update = studentMapper.saveStudent(student);
        return update > 0 ? true : false;
    }
}
