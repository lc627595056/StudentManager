package com.abc.student.service;

import com.abc.student.entity.Repair;

import java.util.List;

public interface RepairService {

    List<Repair> findRepair();

    void addRepair(Repair repair);

    int updateRepair(Repair repair);

    Repair findBySno(String sno);

    void deleteRepair(Integer rid);

    List<Repair> findRepairByStudent(String sno);
}
