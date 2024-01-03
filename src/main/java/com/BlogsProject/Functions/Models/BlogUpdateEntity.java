package com.BlogsProject.Functions.Models;

import com.BlogsProject.Functions.Entity.Comment;
import com.BlogsProject.Functions.Entity.Picture;
import com.BlogsProject.Functions.Entity.Reaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogUpdateEntity {

    int id;

    String title;

    String text;

    String creatorId;

}
