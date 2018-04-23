package com.example.simple.mapper;


import com.example.simple.entity.Seed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SeedRepository extends JpaRepository<Seed, Long> {
//    public abstract Seed findByName(String name);
//    public abstract Seed findByNameAndAge(String name, Integer age);
//    @Query("from User u where u.name=:name")
//    public abstract Seed findUser(@Param("name") String name);
    public Seed findAllBy();
}