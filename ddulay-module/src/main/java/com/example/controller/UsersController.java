package com.example.controller;
import com.example.entity.Users;
import com.example.entity.user.User;
import com.example.service.UsersService;
import com.example.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController(value = "users")
public class UsersController{

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "getusers",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(){
        List<User> value = new ArrayList<>();
        List<Users> users = usersService.findAllUsers();
        for(Users u:users){
            User mappedUser = new User();
            mappedUser.setName(u.getName());
            mappedUser.setAge(u.getAge());
            value.add(mappedUser);
        }
        return value;
    }

    @RequestMapping(value = "createusers",method = RequestMethod.POST)
    @ResponseBody
    public List<User> createUsers(@RequestBody User user ){

        usersService.addNewWebUsers(user);
        List<User> newUser = new ArrayList<>();
        newUser.add(user);

        return newUser;


    }



}
