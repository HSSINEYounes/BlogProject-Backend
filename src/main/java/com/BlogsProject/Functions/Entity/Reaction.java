package com.BlogsProject.Functions.Entity;

import com.BlogsProject.Authentication.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    int id;

    ReactionType reactionType;

    @ManyToOne
    Blog blog;

    @ManyToOne
    User reacter;

}
