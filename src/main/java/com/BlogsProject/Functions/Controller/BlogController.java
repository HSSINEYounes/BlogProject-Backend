package com.BlogsProject.Functions.Controller;

import com.BlogsProject.Functions.Entity.Blog;
import com.BlogsProject.Functions.Models.*;
import com.BlogsProject.Functions.Service.BlogService;
import com.BlogsProject.Functions.Service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/blogController")
public class BlogController {

    private final ModelsServices brs;
    private final BlogService bs;

    @PostMapping("/create-blog")
    public void createBlog(@RequestBody BlogRequestEntity bg){
        brs.saveBlog(bg);
    }

    @PostMapping("/create-blog2")
    public void createBlog2(@RequestBody Blog bg,@RequestBody String uid){
        bs.create(bg,uid);
    }


    @PostMapping("/update-blog")
    public void updateBlogInformation(@RequestBody BlogUpdateEntity bg){
        brs.updateBlogInformation(bg);
    }

    @GetMapping("/get-blogs/{page}/{pageSize}")
    public Page<Blog> findBlogs(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize){
        return bs.findAll(page, pageSize);
    }

    @GetMapping("/find-blogs-by-user/{id}/{page}/{pageSize}")
    public Page<Blog> findBlogsByUser(@PathVariable("id") String id, @PathVariable("page") int page, @PathVariable("pageSize") int pageSize){
        return bs.findBlogsByUser(id, page, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id) {
        Blog blog = bs.findById(id);
        if(blog != null) {
            return ResponseEntity.ok(blog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




















}
