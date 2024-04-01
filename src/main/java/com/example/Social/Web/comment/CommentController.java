package com.example.Social.Web.comment;

import com.example.Social.Web.content.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/allComments")
    public List<Comment> getComments(){
        return commentService.getAllComments();
    }

    @GetMapping("getComment/{CommentID}")
    public Comment getComment(@PathVariable("CommentID") CommentID id){
        return commentService.getSomeComment(id);
    }

    @PostMapping("/addComment")
    public Comment addComment(@RequestBody Comment comment){
        commentService.AddComment(comment);
        return comment;
    }

    @DeleteMapping("Delete/{CommentID}")
    public String deleteComment(@PathVariable("CommentID") CommentID id){
        return commentService.deleteComment(id);
    }

    @PutMapping("Update/{CommentID}")
    public String updateComment(
            @PathVariable("CommentID") CommentID commentId,
            @RequestParam(required = true) String comment_content){
        return commentService.updateComment(commentId, comment_content);
    }
}
