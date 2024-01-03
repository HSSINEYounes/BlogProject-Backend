package com.BlogsProject.Functions.Controller;

import com.BlogsProject.Functions.Entity.Reaction;
import com.BlogsProject.Functions.Models.ModelsServices;
import com.BlogsProject.Functions.Models.ReactionModel;
import com.BlogsProject.Functions.Service.ReactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/reactionController")
public class ReactionController {

    private final ModelsServices ms;
    private final ReactionService rs;

    @PostMapping("/create-reaction")
    public void AddReaction(@RequestBody ReactionModel rm){
        ms.addReaction(rm);
    }

    @DeleteMapping("/delete-reaction/{id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable int id) {
        rs.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getreaction/{id}")
    public void getReactionById(@PathVariable("id") int id){
        rs.findById(id);
    }

    @GetMapping("/getreactions")
    public ResponseEntity<List<Reaction>> getReactions(){
        List<Reaction> reactions = rs.finAll();
        return ResponseEntity.ok(reactions);
    }
    @GetMapping("/getreactions/{id}")
    public ResponseEntity<List<Reaction>> getReactionsByBlog(@PathVariable("id") int id){
        List<Reaction> reactions = rs.findByBlog(id);
        return ResponseEntity.ok(reactions);
    }

    @GetMapping("/getreactions/{idBlog}/{idUser}")
    public ResponseEntity<List<Reaction>> getReactionsByBlogandUser(@PathVariable("idBlog") int idBlog,@PathVariable("idUser") String idUser){
        List<Reaction> reactions = rs.findByBlogandUser(idBlog, idUser);
        return ResponseEntity.ok(reactions);
    }
}
