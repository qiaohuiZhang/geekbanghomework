package week7.homework.service;

import org.springframework.stereotype.Service;
import week7.homework.entity.User;
import week7.homework.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public Boolean inserUser(String userName) {
        int update = userMapper.insertUser(userName);
        return update > 0 ? true : false;
    }

    public List<User> selectUser() {
        List<User> users = userMapper.findUser();
        return users;
    }
}
