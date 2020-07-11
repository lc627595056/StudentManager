package com.abc.student.mapper;

import com.abc.student.entity.Absence;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AbsenceMapper {

    List<Absence> findAbsence();

    void addAbsence(Absence absence);

    int updateAbsence(Absence absence);

    Absence findBySno(String st_sno);

    void deleteAbsence(Integer ab_id);

    List<Absence> findAbsenceByStudent(String sno);
}
