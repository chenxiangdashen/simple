package com.example.simple.mapper;


import com.example.simple.entity.Seed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SeedRepository extends JpaRepository<Seed, Long> {
//    public abstract Seed findByName(String name);
//    public abstract Seed findByNameAndAge(String name, Integer age);
    @Query("from Seed s where s.moiveID=:moiveID")
    public abstract List<Seed> findbyMoiveID(@Param("moiveID") String moiveID);

    public Seed findAllBy();
}