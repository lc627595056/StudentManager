package com.abc.student.service;

import com.abc.student.entity.Announce;

import java.util.List;

public interface AnnounceService {

    List<Announce> findAnnounce();

    int addAnnounce(Announce announce);

    Announce findById(Integer anno_id);

    int updateAnnounce(Announce announce);

    void deleteAnnounce(Integer anno_id);
}
