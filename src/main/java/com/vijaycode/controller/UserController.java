package com.vijaycode.controller;


import com.vijaycode.model.SuccessDO;
import com.vijaycode.model.UserDO;
import com.vijaycode.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<SuccessDO> createUser(@Valid @RequestBody UserDO userDO) {
        return new ResponseEntity<>(userService.createUser(userDO), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDO>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDO> getUser(@PathVariable("userId") Integer userId){
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<SuccessDO> deleteUser(@PathVariable("userId") Integer userId){
        return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.OK);
    }


    @PatchMapping("/user/")
    public ResponseEntity<SuccessDO> updateUser(@RequestHeader("userId") Integer userId,@RequestBody UserDO userDO){
        return new ResponseEntity<>(userService.updateUser(userId,userDO),HttpStatus.OK);
    }




}
