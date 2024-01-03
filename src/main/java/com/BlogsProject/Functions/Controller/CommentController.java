package com.BlogsProject.Functions.Controller;


import com.BlogsProject.Functions.Entity.Comment;
import com.BlogsProject.Functions.Models.CommentModel;
import com.BlogsProject.Functions.Models.ModelsServices;
import com.BlogsProject.Functions.Service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/commentController")
public class CommentController {

    private final ModelsServices brs;
    private final CommentService cs;

    @PostMapping("/create-comment")
    public void addComment(@RequestBody CommentModel cm){
        brs.addComment(cm);
    }

    /*@GetMapping("/find-comments")
    public void getComments(){
        cs.finAll();
    }*/

    @GetMapping("/find-comments")
    public ResponseEntity<List<Comment>> getComments() {
        List<Comment> comments = cs.finAll();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/find-comment-Blog/{id}")
    public ResponseEntity<List<Comment>> getCommentsByBlog(@PathVariable("id") int id) {
        List<Comment> comments = cs.findByBlogId(id);
        return ResponseEntity.ok(comments);
    }

    @GetMapping ("/delete-comment/{id}")
    public void deleteComment(@PathVariable("id") int id){
        cs.delete(cs.findById(id));
    }


}
