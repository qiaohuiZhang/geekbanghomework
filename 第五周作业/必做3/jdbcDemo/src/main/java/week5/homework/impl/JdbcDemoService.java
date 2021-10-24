package week5.homework.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week5.homework.entity.Users;
import week5.homework.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@RestController
//@EnableAutoConfiguration
//@ComponentScan("week5.homework.service")
public class JdbcDemoService {

    @Resource
    private UserService userService;

    @RequestMapping("/addUser")
    public String addUser(String name,int age) {
        userService.inserUser(name,age);
        return "success";
    }

    @RequestMapping("/getUser")
    public Users getUser(int id) {
        return userService.userQry(id);
    }

    @RequestMapping("/updateUser")
    public int getUser(String name,int age,int id) {
        Users users = new Users();
        users.setAge(age);
        users.setName(name);
        users.setId(id);
        return userService.updateUser(users);
    }

    @RequestMapping("/deleteUser")
    public int deleteUser(int id) {
        return userService.deleteUser(id);
    }

    @RequestMapping("/selUsers")
    public String selUsers(int age) {
        userService.selUsers(age);
        return "success";
    }

    @RequestMapping("/selUsers2")
    public String selUsers2(int age) {
        new HikariPoolTest().selUsers(age);
        return "success";
    }



}
