package com.phinzin.myhome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phinzin.myhome.entity.MyHome;
import com.phinzin.myhome.repository.MyHomeRepository;

@Service
public class MyHomeService {
    
    private MyHomeRepository myHomeRepository;

    @Autowired
    public MyHomeService(MyHomeRepository myHomeRepository){
        this.myHomeRepository = myHomeRepository;
    }
    public Iterable<MyHome> getAllItems(){
        return this.myHomeRepository.findAll();
    }
}
