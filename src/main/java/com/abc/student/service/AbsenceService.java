package com.abc.student.service;

import com.abc.student.entity.Absence;

import java.util.List;

public interface AbsenceService {

    List<Absence> findAbsence();

    void addAbsence(Absence absence);

    int updateAbsence(Absence absence);

    Absence findBySno(String st_sno);

    void deleteAbsence(Integer ab_id);

    List<Absence> findAbsenceByStudent(String sno);

}
