package com.phinzin.myhome.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;
import com.phinzin.myhome.entity.MyHome;

@Repository
public interface MyHomeRepository extends CosmosRepository<MyHome,String>{
    Iterable<MyHome> findByName(String name);

    @Query(value = "SELECT * FROM c")
    List<MyHome> findAllItems();
}
