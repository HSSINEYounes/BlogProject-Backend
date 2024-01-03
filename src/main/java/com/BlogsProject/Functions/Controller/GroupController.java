package com.BlogsProject.Functions.Controller;

import com.BlogsProject.Functions.Entity.Blog;
import com.BlogsProject.Functions.Models.GroupeModel;
import com.BlogsProject.Functions.Models.ModelsServices;
import com.BlogsProject.Functions.Service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/groupController")

public class GroupController {

    private final ModelsServices ms;
    private final GroupService gs;

    @PostMapping("/create-group")
    public void AddGroup(@RequestBody GroupeModel gm){
        ms.addGroupe(gm);
    }

    @GetMapping("/get-blogs-by-group/{id}/{page}/{pageSize}")
    public Page<Blog> findBlogs(@PathVariable("id") int id, @PathVariable("page") int page, @PathVariable("pageSize") int pageSize){
        return gs.findBlogsByGroup(id, page, pageSize);
    }

    @GetMapping("/delete-group/{id}")
    public void deleteGroup(@PathVariable("id") int id){
        gs.delete(gs.findById(id));
    }

}
