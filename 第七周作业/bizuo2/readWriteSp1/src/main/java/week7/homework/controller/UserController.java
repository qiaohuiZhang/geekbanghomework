package week7.homework.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week7.homework.entity.User;
import week7.homework.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/addUser")
    public String addUser(String name) {
        userService.inserUser(name);
        return "success";
    }

    @RequestMapping("/selAllUser")
    public String selAllUser() {
        List<User> users = userService.selectUser();
        for (User u:users) {
            System.out.println(u.getUserName());
        }
        return "success";
    }

}
