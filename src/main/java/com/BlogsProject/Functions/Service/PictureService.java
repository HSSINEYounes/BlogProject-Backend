package com.BlogsProject.Functions.Service;

import com.BlogsProject.Functions.Entity.Picture;
import com.BlogsProject.Functions.Repository.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PictureService implements GeneralService<Picture>{

    private final PictureRepository pr;
    @Override
    public void create(Picture picture) {
        pr.save(picture);
    }

    @Override
    public void update(Picture picture) {
        pr.save(picture);
    }

    @Override
    public Picture findById(int id) {
        return pr.findById(id).get();
    }

    @Override
    public List<Picture> finAll() {
        return pr.findAll();
    }

    @Override
    public void delete(Picture picture) {
        pr.delete(picture);
    }
}
