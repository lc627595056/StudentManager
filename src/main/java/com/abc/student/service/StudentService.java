package com.abc.student.service;

import com.abc.student.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {

    List<Student> findStudent();

    void addStudent(Student student);

    Student findBySno(String sno);

    int updateStudent(Student student);

    int deleteStudent(String sno);

    Student loginstudent(@Param("sno") String sno, @Param("password") String password);

    Student checkSno(String sno);
}
