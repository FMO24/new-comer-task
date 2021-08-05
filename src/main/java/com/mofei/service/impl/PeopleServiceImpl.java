package com.mofei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.mofei.dao.PeopleDao;
import com.mofei.pojo.People;
import com.mofei.service.PeopleService;
import com.mofei.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    public void save(People people) {
        String id = UUID.randomUUID().toString();
        id.subSequence(0, 10);
        System.out.println(id);
        people.setId(id);
        peopleDao.save(people);
    }

    public boolean delete(String id) {
        if (StringUtil.isEmpty(id)) {
            return false;
        }
        peopleDao.delete(id);
        return true;
    }

    public boolean update(People people) {
        if (StringUtil.isEmpty(people.getId())) {
            return false;
        }
        peopleDao.update(people);
        return true;
    }

    public PageResult findAll(int page, int size) {

        PageHelper.startPage(page, size);
        List<People> list = peopleDao.findAll();

        PageInfo<People> pageInfo = new PageInfo<>(list);

        PageResult pageResult = new PageResult();
        pageResult.setPage(pageInfo.getPageNum());
        pageResult.setSize(pageInfo.getSize());
        pageResult.setCounts(list.size());
        pageResult.setItems(list);

        return pageResult;
    }
}
