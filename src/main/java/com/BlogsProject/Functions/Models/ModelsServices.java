package com.BlogsProject.Functions.Models;

import com.BlogsProject.Authentication.Entity.User;
import com.BlogsProject.Authentication.Entity.UserRepository;
import com.BlogsProject.Functions.Entity.*;
import com.BlogsProject.Functions.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelsServices {

    private final UserRepository ur;
    private final PictureService ps;
    private final BlogService bs;
    private final CommentService cs;
    private final ReactionService rs;
    private final GroupService gs;

    public void saveBlog(BlogRequestEntity bg){

        User user = ur.findById(bg.creatorId).get();

        List<Picture> pictures = new ArrayList<>();

        for(PictureModel picture: bg.pictures){    // Pictures Creation
            Picture pic = Picture.builder()
                    .title(picture.title)
                    .url(picture.url)
                    .build();
            ps.create(pic);

            pictures.add(pic);        // Add picture to Blog
        }

        Blog blog = Blog.builder()               // Blog creation
                .title(bg.title)
                .text(bg.text)
                .creator(user)
                .pictures(pictures)
                .build();
        bs.create(blog);

    }

    public void updateBlogInformation(BlogUpdateEntity bg){

//        User user = ur.findById(bg.creatorId).get();

        User user;
        Blog blog = bs.findById(bg.getId());

        if(bg.creatorId == blog.getCreator().getUid()){
            blog.setText(bg.text);
            blog.setTitle(bg.title);
            bs.create(blog);
        }
    }

    public void addComment(CommentModel cm){

        Comment comment = Comment.builder()
                .blog(bs.findById(cm.blogId))
                .text(cm.text)
                .commenter(ur.findById(cm.commenterId).get())
                .build();
        cs.create(comment);
    }

    public void addReaction(ReactionModel rm){

        Reaction reaction = null;
        if(rm.reactionType.name() == "DISAPPROUVE"){
            reaction = Reaction.builder()
                    .reacter(ur.findById(rm.reactorId).get())
                    .reactionType(ReactionType.DISAPPROUVE)
                    .blog(bs.findById(rm.blogId))
                    .build();
        }
        else if(rm.reactionType.name() == "APPROUVE"){
            reaction = Reaction.builder()
                    .reacter(ur.findById(rm.reactorId).get())
                    .reactionType(ReactionType.APPROUVE)
                    .blog(bs.findById(rm.blogId))
                    .build();
        }

        rs.create(reaction);

    }

    public void addGroupe(GroupeModel gm){

        Picture pic = Picture.builder()
                .title(gm.picture.getTitle())
                .url(gm.picture.getUrl())
                .build();
        ps.create(pic);

        Groupe groupe = Groupe.builder()
                .creator(ur.findById(gm.creatorId).get())
                .description(gm.description)
                .picture(pic)
                .domain(gm.domain)
                .name(gm.name)
                .build();

        gs.create(groupe);
    }


}
