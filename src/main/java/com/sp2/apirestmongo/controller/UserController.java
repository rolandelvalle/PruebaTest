package com.sp2.apirestmongo.controller;


import com.sp2.apirestmongo.dto.UserDto;
import com.sp2.apirestmongo.model.User;
import com.sp2.apirestmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        if(users.size() == 0){
            return new ResponseEntity("The collection is empty", HttpStatus.NOT_FOUND);

        }else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id){
        User user = userService.findById(id);
        if (user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else {
            return new ResponseEntity("The id " + id + " is not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
        User user = userService.createUser(userDto);
        if (user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else {
            return new ResponseEntity("Error creating user", HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody UserDto userDto){
        User user = userService.updateUser(id, userDto);
        if (user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity("The user to update does not exist", HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") String id){
        Boolean isDeleted = userService.deleteUser(id);
        if (isDeleted){
            return new ResponseEntity<>(isDeleted, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(isDeleted, HttpStatus.NOT_FOUND);
        }

    }

}
