package com.BlogsProject.Functions.Repository;

import com.BlogsProject.Authentication.Entity.User;
import com.BlogsProject.Functions.Entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogReposiory extends JpaRepository<Blog, Integer> {

    Page<Blog> findAll(Pageable pageable);


    Page<Blog> findByCreator(User user, Pageable pageable);
}
