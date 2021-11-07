package week7.homework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import week7.homework.entity.User;

public interface UserMapper {
    @Select("SELECT user_name as userName FROM  user ")
    public List<User> findUser();

    @Insert("insert into user(user_name) values (#{userName}); ")
    public int insertUser(@Param("userName") String userName);
}