package com.BlogsProject.Functions.Service;

import com.BlogsProject.Functions.Entity.Comment;
import com.BlogsProject.Functions.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements GeneralService<Comment> {

    private final CommentRepository cr;

    @Override
    public void create(Comment comment) {
        cr.save(comment);
    }

    @Override
    public void update(Comment comment) {
        cr.save(comment);
    }

    @Override
    public Comment findById(int id) {
        return cr.findById(id).get();
    }

    @Override
    public List<Comment> finAll() {
        return cr.findAll();
    }
    public List<Comment> findByBlogId(int id) {
        return cr.findByBlogId(id);
    }

    @Override
    public void delete(Comment comment) {
        cr.delete(comment);
    }
}
