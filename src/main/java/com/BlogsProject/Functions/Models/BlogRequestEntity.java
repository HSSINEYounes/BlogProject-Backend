package com.BlogsProject.Functions.Models;


import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BlogRequestEntity {

    String title;

    String text;

    String creatorId;

    List<PictureModel> pictures;

}
