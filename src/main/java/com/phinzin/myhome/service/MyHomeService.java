package com.phinzin.myhome.service;

import java.util.List;

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
    public List<MyHome> getAllItems(){
        return this.myHomeRepository.findAllItems();
    }
    public MyHome addItem(MyHome myHome) {
        return this.myHomeRepository.save(myHome);
    }
    public MyHome editItem(MyHome myHome) {
        return this.myHomeRepository.save(myHome);
    }
    public void deleteItem(String id) {
        this.myHomeRepository.deleteById(id);
    }
}
