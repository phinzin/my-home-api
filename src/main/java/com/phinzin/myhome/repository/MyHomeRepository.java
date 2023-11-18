package com.phinzin.myhome.repository;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.phinzin.myhome.entity.MyHome;

@Repository
public interface MyHomeRepository extends CosmosRepository<MyHome,String>{
    Iterable<MyHome> findByName(String name);
    MyHome findOne(String id,String partitionKey);
}
