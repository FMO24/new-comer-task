package com.mofei.service;

import com.github.pagehelper.PageInfo;
import com.mofei.pojo.People;
import com.mofei.vo.PageResult;

public interface PeopleService {

    void save(People people);

    boolean delete(String id);

    boolean update(People people);

    PageResult findAll(int page, int size);

}
