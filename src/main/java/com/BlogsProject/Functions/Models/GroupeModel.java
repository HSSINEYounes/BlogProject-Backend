package com.BlogsProject.Functions.Models;

import com.BlogsProject.Authentication.Entity.User;
import com.BlogsProject.Functions.Entity.Picture;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GroupeModel {

    String name;

    String description;

    String domain;

    PictureModel picture;

    String creatorId;
}
