package com.BlogsProject.Functions.Repository;

import com.BlogsProject.Functions.Entity.Blog;
import com.BlogsProject.Functions.Entity.Groupe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface GroupRepository extends JpaRepository<Groupe, Integer> {

    @Query("SELECT G.blogs FROM Groupe G WHERE G.id= :id")
    Page<Blog> findBlogsByGroup(@Param("id") int id, Pageable pageable);
}
