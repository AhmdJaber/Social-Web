package com.example.Social.Web.comment;

import com.example.Social.Web.content.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private ContentRepository contentRepository;
    private final CommentRepository commentRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public Comment getSomeComment(Long comment_id){
        return commentRepository.findById(comment_id).orElseThrow(
                () -> new IllegalStateException("There is no Comment with ID = " + comment_id)
        );
    }

    public void AddComment(Comment comment){
        if (comment.getContent().getType() != null){
            throw new IllegalStateException("This content id: " +
                    comment.getContent().getContent_id()
                    + " is already used for another content");
        }

        comment.setContent(contentRepository.findById(
                comment.getContent().getContent_id()).orElseThrow(
                        () -> new IllegalStateException("There is not content with this id")
                )
        );
        comment.getContent().setType("comment");
        commentRepository.save(comment);
    }

    public String deleteComment(Long comment_id){
        boolean chk = commentRepository.existsById(comment_id);
        if (chk){
            commentRepository.deleteById(comment_id);
            return "The Comment with ID = " + comment_id + " has been deleted!";
        }

        return "There is not comment with id = " + comment_id;
    }

    public String updateComment(Long comment_id, String comment_content){
        Comment comment = commentRepository.findById(comment_id).orElseThrow(
                () -> new IllegalStateException("There is no Comment with ID = " + comment_id)
        );

        comment.setComment_content(comment_content);
        return "Action is done";
    }

}
