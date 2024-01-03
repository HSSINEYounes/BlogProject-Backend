package com.BlogsProject.Functions.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserModel {

    private String uid;
    private String firstname;
    private String lastname;
    private String profilDescription;

}
