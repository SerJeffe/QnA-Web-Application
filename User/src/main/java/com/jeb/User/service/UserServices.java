package com.jeb.User.service;

import com.jeb.User.model.User;
import com.jeb.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public String deleteUser(Integer id){
        userRepository.deleteById(id);
        return "User has been deleted";
    }

    public String updateUser(User user) {
        userRepository.save(user);
        return user.getName()+" has been updated";
    }
}
