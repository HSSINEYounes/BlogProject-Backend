package com.BlogsProject.Functions.Service;

import com.BlogsProject.Authentication.Entity.User;
import com.BlogsProject.Authentication.Entity.UserRepository;
import com.BlogsProject.Functions.Entity.Blog;
import com.BlogsProject.Functions.Entity.UserModel;
import com.BlogsProject.Functions.Repository.BlogReposiory;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository ur;
    private final BlogReposiory br;

    public List<UserModel> findUsersByNameDebut(String debut, int page, int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<User> pg =ur.findUserByNameDebut(debut, pageable);
        List<User> list = pg.getContent();
        List<UserModel> outputList = new ArrayList<>();
        for(User user: list){
            UserModel um = UserModel.builder()
                    .uid(user.getUid())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .profilDescription(user.getProfilDescription())
                    .build();
            outputList.add(um);
        }
        return outputList;
    }

    public List<UserModel> findAll(int page, int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<User> pg =ur.findAll(pageable);
        List<User> list = pg.getContent();
        List<UserModel> outputList = new ArrayList<>();
        for(User user: list){
            UserModel um = UserModel.builder()
                    .uid(user.getUid())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .profilDescription(user.getProfilDescription())
                    .build();
            outputList.add(um);
        }
        return outputList;
    }

    public User findByUid(String uid){
        User user = ur.findByUid(uid);
        List<UserModel> outputList = new ArrayList<>();
            UserModel um = UserModel.builder()
                    .uid(user.getUid())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .profilDescription(user.getProfilDescription())
                    .build();
            outputList.add(um);
        return user;
    }


    public void create(Blog blog, String creatorId) {
        // Fetch the user based on the creatorId
        User user = ur.findById(creatorId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + creatorId));

        blog.setCreator(user);

        // Save the blog
        br.save(blog);
    }
}
