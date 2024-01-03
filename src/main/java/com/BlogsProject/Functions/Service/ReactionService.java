package com.BlogsProject.Functions.Service;

import com.BlogsProject.Functions.Entity.Reaction;
import com.BlogsProject.Functions.Repository.BlogReposiory;
import com.BlogsProject.Functions.Repository.ReactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReactionService implements GeneralService<Reaction>{

    public final ReactionRepository rr;
    public final BlogReposiory br;

    @Override
    public void create(Reaction reaction) {
        rr.save(reaction);
    }

    @Override
    public void update(Reaction reaction) {
        rr.save(reaction);
    }

    @Override
    public Reaction findById(int id) {
        return rr.findById(id).get();
    }

    public void deleteById(int id){
        rr.deleteById(id);
    }

    public List<Reaction> findByBlog(int id) {return rr.findByBlogId(id);
    }

    public List<Reaction> findByBlogandUser(int idblog, String idUser) {return rr.findByBlogIdUserId(idblog, idUser);
    }
    @Override
    public List<Reaction> finAll() {
        return rr.findAll();
    }

    @Override
    public void delete(Reaction reaction) {
        rr.delete(reaction);
    }
}
