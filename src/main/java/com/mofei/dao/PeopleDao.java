package com.mofei.dao;

import com.mofei.pojo.People;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PeopleDao {

    void save(People people);

    void delete(String id);

    void update(People people);

    List<People> findAll();
}
