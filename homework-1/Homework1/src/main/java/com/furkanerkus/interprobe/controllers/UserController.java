package com.furkanerkus.interprobe.controllers;

import com.furkanerkus.interprobe.dao.ProductCommentDao;
import com.furkanerkus.interprobe.dao.Userdao;
import com.furkanerkus.interprobe.entity.ProductComment;
import com.furkanerkus.interprobe.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final Userdao userdao;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userdao.save(user);
    }

    @GetMapping("/showAllUsers")
    public List<User> showAllUsers() {
        return userdao.findAll();
    }


}
