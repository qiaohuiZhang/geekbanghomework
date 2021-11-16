package week8.homework.mapper2;

import org.springframework.stereotype.Repository;
import week8.homework.entity.Teacher;

@Repository
public interface TeacherMapper {
    int saveTeacher(Teacher teacher);
}