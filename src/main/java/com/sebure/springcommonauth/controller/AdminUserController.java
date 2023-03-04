package com.sebure.springcommonauth.controller;

import com.sebure.springcommonauth.entity.AdminUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin-users")
public class AdminUserController {


    @GetMapping("/{id}")
    public ResponseEntity<AdminUser> getUserById(@PathVariable("id") Long id) {
//        User user = userService.getUserById(id);
//        if (user != null) {
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<AdminUser> createUser(@RequestBody AdminUser adminUser) {
//        User newUser = userService.createUser(user);
//        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminUser> updateUser(@PathVariable("id") Long id, @RequestBody AdminUser adminUser) {
//        User updatedUser = userService.updateUser(id, user);
//        if (updatedUser != null) {
//            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
//        boolean deleted = userService.deleteUser(id);
//        if (deleted) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return null;
    }
}
