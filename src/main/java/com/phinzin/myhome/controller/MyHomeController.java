package com.phinzin.myhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phinzin.myhome.entity.MyHome;
import com.phinzin.myhome.service.MyHomeService;

@RestController
@RequestMapping("/api/my-home")
public class MyHomeController {
    
    private final MyHomeService myHomeService;

    @Autowired
    public MyHomeController(MyHomeService myHomeService){
        this.myHomeService = myHomeService;
    }
    @GetMapping("/all")
    public Iterable<MyHome> getAllItems(){
        return this.myHomeService.getAllItems();
    }
}
