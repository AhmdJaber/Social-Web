package com.example.Social.Web.comment;

import org.hibernate.annotations.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Comment")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/allComments")
    public List<Comment> getComments(){
        return commentRepository.findAll();
    }

    @PostMapping("/addComment")
    public Comment addComment(@RequestBody Comment comment){
        return commentRepository.save(comment);
    }
}
