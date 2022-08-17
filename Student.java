package com.example.day8hw1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @Data @NoArgsConstructor @Entity
public class Student {

    // 1
    @NotNull
    @Id
    private Integer Id;
    // 2
    @NotEmpty
    private String name;
    // 3
    @NotNull
    private Integer age;
    //4
    @NotEmpty
    @Column (columnDefinition = "varchar(10) check(name='CS' or name='user'or name = 'Enginner")
    private String major;






}// end
