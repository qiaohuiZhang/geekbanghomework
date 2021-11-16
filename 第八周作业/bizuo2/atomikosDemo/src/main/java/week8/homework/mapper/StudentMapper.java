package week8.homework.mapper;

import org.springframework.stereotype.Repository;
import week8.homework.entity.Student;

@Repository
public interface StudentMapper {
    int saveStudent(Student student);
}