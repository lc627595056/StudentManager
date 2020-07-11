package com.abc.student.mapper;

import com.abc.student.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> findStudent();

    void addStudent(Student student);

    Student findBySno(String sno);

    int updateStudent(Student student);

    void deleteStudent(String sno);

    Student loginstudent(@Param("sno") String sno, @Param("password") String password);

    Student checkSno(String sno);
}
