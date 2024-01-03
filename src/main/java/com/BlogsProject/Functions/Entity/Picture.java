package com.BlogsProject.Functions.Entity;

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

public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String title;

    String url;

}
