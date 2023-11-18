package com.phinzin.myhome.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * MyHome
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Container(containerName = "Items", ru = "400")
public class MyHome {
    @PartitionKey
    private String partitionKey;
    private String id;
    private String name;
    private String executedDate;
    private String nextStage;
    private String remark;
    
}