package com.example.service;

import com.example.entity.Users;
import com.example.entity.user.User;


import java.util.List;


public interface UsersService {


    List<Users> findAllUsers();



    void addNewWebUsers(User usersRepository);
}

