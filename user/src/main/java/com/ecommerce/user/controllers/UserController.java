package com.ecommerce.user.controllers;

import com.ecommerce.user.services.UserService;
import com.ecommerce.user.dto.UserRequest;
import com.ecommerce.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")//base url
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.fetchAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long id){
//        User user = userService.fetchUser(id);
//        if(user == null){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(user);
//        instead of above we can do it betre as below
        return userService.fetchUser(id)
                .map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
        return ResponseEntity.ok("user added successfully");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id , @RequestBody UserRequest updatedUserRequest){
        boolean updated  = userService.updateUser(id, updatedUserRequest);
        if(updated){
            return ResponseEntity.ok("user updated successfully");
        }
        return  ResponseEntity.notFound().build();
    }

}
