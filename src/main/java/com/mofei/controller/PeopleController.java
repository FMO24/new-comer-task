package com.mofei.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.mofei.pojo.People;
import com.mofei.service.PeopleService;
import com.mofei.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("start")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @PostMapping("save")
    public ResponseEntity<String> save(@RequestBody People people) {

        try {
            peopleService.save(people);
            return ResponseEntity.ok("save successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
        try {
            boolean res = peopleService.delete(id);
            if (res) {
                return ResponseEntity.ok("delete successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    @PostMapping("update")
    public ResponseEntity<String> update(@RequestBody People people) {
        try {
            boolean res = peopleService.update(people);
            if (res) {
                return ResponseEntity.ok("update successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("findAll")
    public ResponseEntity<PageResult> findAll(@RequestParam(value = "page") int page,
                                            @RequestParam(value = "size") int size) {
        try {
            PageResult res = peopleService.findAll(page, size);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
