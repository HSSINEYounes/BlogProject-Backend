package com.BlogsProject.Functions.Entity;

import com.BlogsProject.Authentication.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String title;

    String text;

    @ManyToOne
    User creator;

    @OneToMany
    List<Picture> pictures;

    @ManyToOne
    Groupe groupe;

}
