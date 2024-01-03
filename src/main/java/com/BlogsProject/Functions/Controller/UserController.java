package com.BlogsProject.Functions.Controller;

import com.BlogsProject.Authentication.Entity.User;
import com.BlogsProject.Authentication.Entity.UserRepository;
import com.BlogsProject.Functions.Entity.Blog;
import com.BlogsProject.Functions.Entity.UserModel;
import com.BlogsProject.Functions.Repository.BlogReposiory;
import com.BlogsProject.Functions.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userController")
@RequiredArgsConstructor
@Slf4j

public class UserController {

    private final UserService us;

    @GetMapping("/find-users-by-debut/{debut}/{page}/{pageSize}")
    public List<UserModel> findUsersByNameDebut(@PathVariable("debut") String debut, @PathVariable("page") int page, @PathVariable("pageSize") int pageSize){
        return us.findUsersByNameDebut(debut, page, pageSize);
    }

    @GetMapping("/findAll/{page}/{pageSize}")
    public List<UserModel> findAllUsers(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize){
        return us.findAll(page, pageSize);
    }

    @GetMapping("/findByUid/{uid}")
    public User findByUid(@PathVariable("uid") String uid){
        return us.findByUid(uid);
    }



}
