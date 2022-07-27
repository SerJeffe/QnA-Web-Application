package com.jeb.User.controller;

import com.jeb.User.model.User;
import com.jeb.User.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jeb")
public class ApiController {
    @Autowired
    UserServices userServices;

    @GetMapping("/user/all")
    public ResponseEntity<?> getUsers(){
        return new ResponseEntity<>(userServices.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/user/save/{id}/{username}/{name}/{password}/{email}/{location}/{phone}/{about}/{loggedIn}")
    public ResponseEntity<?> saveUser(@PathVariable("id") Integer id,@PathVariable("username") String username,@PathVariable("name") String name,@PathVariable("password") String password,@PathVariable("email") String email,@PathVariable("location") String location,@PathVariable("phone") String phone,@PathVariable("about") String about,@PathVariable("loggedIn") boolean loggedIn){

        return new ResponseEntity<>("User has been added "+userServices.saveUser(new User(id,username,name,password,email,location,phone,about,loggedIn)),HttpStatus.CREATED);
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userServices.deleteUser(id),HttpStatus.OK);
    }

    @PutMapping("/user/update/{id}/{username}/{name}/{password}/{email}/{location}/{phone}/{about}/{loggedIn}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Integer id,@PathVariable("username") String username,@PathVariable("name") String name,@PathVariable("password") String password,@PathVariable("email") String email,@PathVariable("location") String location,@PathVariable("phone") String phone,@PathVariable("about") String about,@PathVariable("loggedIn") boolean loggedIn){

        return new ResponseEntity<>("User has been added "+userServices.updateUser(new User(id,username,name,password,email,location,phone,about,loggedIn)),HttpStatus.CREATED);
    }
}
