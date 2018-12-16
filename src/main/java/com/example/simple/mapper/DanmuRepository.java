package com.example.simple.mapper;


import com.example.simple.entity.Danmu;
import com.example.simple.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DanmuRepository extends JpaRepository<Danmu, Long> {
//    public abstract Seed findByName(String name);
//    public abstract Seed findByNameAndAge(String name, Integer age);
//    @Query("from User u where u.name=:name")
//    public abstract Seed findUser(@Param("name") String name);

}