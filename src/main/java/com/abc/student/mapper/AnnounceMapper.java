package com.abc.student.mapper;

import com.abc.student.entity.Announce;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnounceMapper {

    List<Announce> findAnnounce();

    int addAnnounce(Announce announce);

    Announce findById(Integer anno_id);

    int updateAnnounce(Announce announce);

    void deleteAnnounce(Integer anno_id);
}
