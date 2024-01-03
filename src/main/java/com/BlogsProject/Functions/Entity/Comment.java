package com.BlogsProject.Functions.Entity;

import com.BlogsProject.Authentication.Entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Comment {

    @Id
    @GeneratedValue
    int id;

    String text;

    @ManyToOne
    User commenter;

    @ManyToOne
    Blog blog;
}
