package com.example.day8hw1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @Data @NoArgsConstructor @Entity
public class Teacher {

    // 1
    @NotNull
    private Integer id ;
    // 2
    @NotEmpty
    private String name;
    // 3
    @NotNull
    private Integer salary;
}//
