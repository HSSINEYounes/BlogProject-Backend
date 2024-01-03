package com.BlogsProject.Functions.Repository;

import com.BlogsProject.Functions.Entity.Comment;
import com.BlogsProject.Functions.Entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReactionRepository extends JpaRepository<Reaction, Integer> {

    @Query("SELECT R FROM Reaction R WHERE R.blog.id= :id")
    List<Reaction> findByBlogId(int id);

    @Query("SELECT R FROM Reaction R WHERE R.blog.id= :idblog AND R.reacter.uid= :idUser")
    List<Reaction> findByBlogIdUserId(int idblog, String idUser);
}
