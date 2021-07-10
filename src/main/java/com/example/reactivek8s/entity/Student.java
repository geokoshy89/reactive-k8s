package com.example.reactivek8s.entity;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Student{
    @Id
    private Integer id;
    private String name;

}