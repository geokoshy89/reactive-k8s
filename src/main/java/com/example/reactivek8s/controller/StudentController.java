package com.example.reactivek8s.controller;

import com.example.reactivek8s.entity.Student;
import com.example.reactivek8s.repository.StudentRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController{
    private final StudentRepository repository;
    @GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Student> getStudents(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Student> findStudentById(@PathVariable Integer id){
        return repository.findById(id);
    }
}