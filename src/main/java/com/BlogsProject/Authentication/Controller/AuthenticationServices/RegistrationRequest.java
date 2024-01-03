package com.BlogsProject.Authentication.Controller.AuthenticationServices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String profilDescription;
    private String email;
    private String phonenumber;
}
