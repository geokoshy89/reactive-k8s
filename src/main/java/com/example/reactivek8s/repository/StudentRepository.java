package com.example.reactivek8s.repository;

import com.example.reactivek8s.entity.Student;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StudentRepository extends ReactiveCrudRepository<Student,Integer>{
    
}