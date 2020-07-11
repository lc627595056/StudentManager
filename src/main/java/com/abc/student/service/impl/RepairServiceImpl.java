package com.abc.student.service.impl;

import com.abc.student.entity.Repair;
import com.abc.student.mapper.RepairMapper;
import com.abc.student.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairMapper repairMapper;

    @Override
    public List<Repair> findRepair() {
        return repairMapper.findRepair();
    }

    @Override
    public void addRepair(Repair repair) {
        repairMapper.addRepair(repair);
    }

    @Override
    public int updateRepair(Repair repair) {
        repairMapper.updateRepair(repair);
        return 0;
    }

    @Override
    public Repair findBySno(String sno) {
        return repairMapper.findBySno(sno);
    }

    @Override
    public void deleteRepair(Integer rid) {
        repairMapper.deleteRepair(rid);
    }

    @Override
    public List<Repair> findRepairByStudent(String sno) {
        return repairMapper.findRepairByStudent(sno);
    }

}
