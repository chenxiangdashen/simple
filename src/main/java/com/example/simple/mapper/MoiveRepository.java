package com.example.simple.mapper;


import com.example.simple.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface MoiveRepository extends JpaRepository<Movie, Long> {
//    public abstract Seed findByName(String name);
//    public abstract Seed findByNameAndAge(String name, Integer age);
//    @Query("from User u where u.name=:name")
//    public abstract Seed findUser(@Param("name") String name);



    public Movie findAllBy();
}