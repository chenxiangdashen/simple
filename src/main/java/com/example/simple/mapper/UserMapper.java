package com.example.simple.mapper;

import com.example.simple.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("SELECT * FROM User WHERE id = #{id}")
    User selectUser(int id);
}
