package com.BlogsProject.Functions.Models;

import com.BlogsProject.Functions.Entity.Blog;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentModel {

    int id;

    String text;

    String commenterId;

    int blogId;
}
