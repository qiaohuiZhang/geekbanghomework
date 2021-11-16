package week8.homework.service;

import org.springframework.stereotype.Service;
import week8.homework.entity.Teacher;
import week8.homework.mapper2.TeacherMapper;

import javax.annotation.Resource;

@Service
public class TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    public Boolean saveTeacher(Teacher teacher) {
        int update = teacherMapper.saveTeacher(teacher);
        return update > 0 ? true : false;
    }
}
