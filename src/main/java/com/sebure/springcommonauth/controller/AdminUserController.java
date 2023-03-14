package com.sebure.springcommonauth.controller;

import com.sebure.springcommonauth.controller.dto.in.LoginInDto;
import com.sebure.springcommonauth.controller.dto.out.TokenOutDto;
import com.sebure.springcommonauth.entity.AdminUser;
import com.sebure.springcommonauth.security.AuthManager;
import com.sebure.springcommonauth.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin-users")
public class AdminUserController {

    private final AuthManager authManager;

    private final AdminUserService adminUserService;

    @PostMapping("/_login")
    public ResponseEntity<TokenOutDto> login(@RequestBody LoginInDto loginInDto){
        log.info(loginInDto.toString());
        return ResponseEntity.ok(authManager.loginAdminUser(loginInDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminUser> getUserById(@PathVariable("id") Long id) {
        AdminUser adminUser = adminUserService.getAdminUserById(id);
        if(adminUser == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(adminUser);
        }
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
