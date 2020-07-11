package com.abc.student.mapper;

import com.abc.student.entity.Repair;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RepairMapper {

    List<Repair> findRepair();

    void addRepair(Repair repair);

    void updateRepair(Repair repair);

    Repair findBySno(String sno);

    void deleteRepair(Integer rid);

    List<Repair> findRepairByStudent(String sno);
}
