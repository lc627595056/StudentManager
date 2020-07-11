package com.abc.student.service.impl;

import com.abc.student.entity.Absence;
import com.abc.student.mapper.AbsenceMapper;
import com.abc.student.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    @Autowired
    private AbsenceMapper absenceMapper;

    @Override
    public List<Absence> findAbsence() {
        return absenceMapper.findAbsence();
    }

    @Override
    public void addAbsence(Absence absence) {
        absenceMapper.addAbsence(absence);
    }

    @Override
    public int updateAbsence(Absence absence) {

        return absenceMapper.updateAbsence(absence);
    }

    @Override
    public Absence findBySno(String st_sno) {
        return absenceMapper.findBySno(st_sno);
    }

    @Override
    public void deleteAbsence(Integer ab_id) {
        absenceMapper.deleteAbsence(ab_id);
    }

    @Override
    public List<Absence> findAbsenceByStudent(String sno) {
        return absenceMapper.findAbsenceByStudent(sno);
    }
}
