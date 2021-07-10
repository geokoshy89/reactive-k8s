package com.example.reactivek8s.init;

import com.example.reactivek8s.entity.Student;
import com.example.reactivek8s.repository.StudentRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Configuration
@RequiredArgsConstructor
public class Initializer{
    private final StudentRepository repository;
    @Bean
    public ApplicationRunner init(DatabaseClient databaseClient){
        return args->
                databaseClient.sql("create table if not exists student (id serial primary key,name varchar(255) not null)").fetch().first()
                .then(repository.deleteAll())
                 .thenMany(Flux.just("George","Koshy","Rubin","Sara","Kmpt","Mary","Johan","Janet")
                ).
                map(name->new Student(null,name))
                .flatMap(student->repository.save(student))
                .thenMany(repository.findAll())
                .subscribe(System.out::println);
                    

    }
}