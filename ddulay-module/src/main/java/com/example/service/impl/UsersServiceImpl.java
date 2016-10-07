package com.example.service.impl;


import com.example.entity.Users;
import com.example.entity.user.User;
import com.example.repository.UsersRepository;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> findAllUsers(){
        return usersRepository.findAll();

    }

    @Override
    public void addNewWebUsers(User user){
        Users users=new Users();
        users.setAge(user.getAge());
        users.setName(user.getName());
        usersRepository.save(users);
    }
}
