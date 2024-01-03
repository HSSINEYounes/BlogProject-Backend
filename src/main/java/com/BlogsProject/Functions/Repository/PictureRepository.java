package com.BlogsProject.Functions.Repository;

import com.BlogsProject.Functions.Entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
