package com.abc.student.service.impl;

import com.abc.student.entity.Student;
import com.abc.student.mapper.StudentMapper;
import com.abc.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findStudent() {
        return studentMapper.findStudent();
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public Student findBySno(String sno) {
        return studentMapper.findBySno(sno);
    }

    @Override
    public int updateStudent(Student student) {

        return studentMapper.updateStudent(student);
    }

    @Override
    public int deleteStudent(String sno) {
        studentMapper.deleteStudent(sno);
        return 0;
    }

    @Override
    public Student loginstudent(String sno, String password) {
        return studentMapper.loginstudent(sno,password);
    }

    @Override
    public Student checkSno(String sno) {
        return studentMapper.checkSno(sno);
    }
}
