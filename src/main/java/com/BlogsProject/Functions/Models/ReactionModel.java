package com.BlogsProject.Functions.Models;


import com.BlogsProject.Functions.Entity.ReactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReactionModel {

    ReactionType reactionType;

    int blogId;

    String reactorId;
}
