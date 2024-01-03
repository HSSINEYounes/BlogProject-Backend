package com.BlogsProject.Functions.Repository;

import com.BlogsProject.Authentication.Entity.User;
import com.BlogsProject.Functions.Entity.Blog;
import com.BlogsProject.Functions.Entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("SELECT C FROM Comment C WHERE C.blog.id= :id")
    List<Comment> findByBlogId(int id);
}
