package com.phinzin.myhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phinzin.myhome.entity.MyHome;
import com.phinzin.myhome.service.MyHomeService;


@RestController
@CrossOrigin(origins = "*,https://nhacuatui.azurewebsites.net", maxAge = 3600)
@RequestMapping("/api/my-home")
public class MyHomeController {
    
    private final MyHomeService myHomeService;

    @Autowired
    public MyHomeController(MyHomeService myHomeService){
        this.myHomeService = myHomeService;
    }
    @GetMapping("/all")
    public List<MyHome> getAllItems(){
        return this.myHomeService.getAllItems();
    }
    @PostMapping()
    public ResponseEntity<String> addItem(@RequestBody MyHome myHome){
        myHome.setId(null);
        myHome.setPartitionKey(null);
        this.myHomeService.addItem(myHome);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<String> editItem(@RequestBody MyHome myHome){
        this.myHomeService.editItem(myHome);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
