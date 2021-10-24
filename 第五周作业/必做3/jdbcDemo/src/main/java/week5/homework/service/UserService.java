package week5.homework.service;


import week5.homework.entity.Users;

public interface UserService {

    Boolean inserUser(String name, Integer age);

    Users userQry(Integer id);

    int updateUser(Users user);

    int deleteUser(Integer id);

    void selUsers(Integer age);
}
