package com.abc.student.service.impl;

import com.abc.student.entity.Announce;
import com.abc.student.mapper.AnnounceMapper;
import com.abc.student.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnounceServiceImpl implements AnnounceService {

    @Autowired
    private AnnounceMapper announceMapper;

    @Override
    public List<Announce> findAnnounce() {
        return announceMapper.findAnnounce();
    }

    @Override
    public int addAnnounce(Announce announce) {
        return announceMapper.addAnnounce(announce);
    }

    @Override
    public Announce findById(Integer anno_id) {
        return announceMapper.findById(anno_id);
    }

    @Override
    public int updateAnnounce(Announce announce) {
        return announceMapper.updateAnnounce(announce);
    }

    @Override
    public void deleteAnnounce(Integer anno_id) {
        announceMapper.deleteAnnounce(anno_id);
    }
}
