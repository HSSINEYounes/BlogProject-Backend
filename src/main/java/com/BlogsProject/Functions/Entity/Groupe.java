package com.BlogsProject.Functions.Entity;

import com.BlogsProject.Authentication.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    String description;

    String domain;

    @OneToOne
    Picture picture;

    @ManyToOne
    User creator;

    @OneToMany
    List<Blog> blogs;
}