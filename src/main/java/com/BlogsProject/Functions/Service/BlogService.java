package com.BlogsProject.Functions.Service;

import com.BlogsProject.Authentication.Entity.User;
import com.BlogsProject.Authentication.Entity.UserRepository;
import com.BlogsProject.Functions.Entity.Blog;
import com.BlogsProject.Functions.Repository.BlogReposiory;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService implements GeneralService<Blog>{

    private final BlogReposiory br;
    private final UserRepository ur;

    @Override
    public void create(Blog blog) {
        br.save(blog);
    }

    @Override
    public void update(Blog blog) {
        br.save(blog);
    }

    @Override
    public Blog findById(int id) {        // WHAT IS THE SOLUTION, SHOULD I USE THE OPTIONAL OR NOT
        return br.findById(id).get();
    }

    @Override
    public List<Blog> finAll() {
        return br.findAll();
    }

    @Override
    public void delete(Blog blog) {
        br.delete(blog);
    }

    public Page<Blog> findAll(int page, int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("id"));
        return br.findAll(pageable);
    }

    public Page<Blog> findBlogsByUser(String id, int page, int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("id").descending());
        return br.findByCreator(ur.findById(id).get(), pageable);
    }

    public void create(Blog blog, String creatorId) {
        User user = ur.findById(creatorId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + creatorId));
        blog.setCreator(user);
        br.save(blog);
    }
}
