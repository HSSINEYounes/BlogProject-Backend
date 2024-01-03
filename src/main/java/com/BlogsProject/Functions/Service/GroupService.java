package com.BlogsProject.Functions.Service;

import com.BlogsProject.Functions.Entity.Blog;
import com.BlogsProject.Functions.Entity.Groupe;
import com.BlogsProject.Functions.Repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService implements GeneralService<Groupe> {

    private final GroupRepository gr;

    @Override
    public void create(Groupe groupe) {
        gr.save(groupe);
    }

    @Override
    public void update(Groupe groupe) {
        gr.save(groupe);
    }

    @Override
    public Groupe findById(int id) {
        return gr.findById(id).get();
    }

    @Override
    public List<Groupe> finAll() {
        return gr.findAll();
    }

    @Override
    public void delete(Groupe groupe) {
        gr.delete(groupe);
    }

    public Page<Blog> findBlogsByGroup(int id, int page, int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("id").descending());
        return gr.findBlogsByGroup(id, pageable);
    }
}
