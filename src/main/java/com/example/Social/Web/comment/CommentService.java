package com.example.Social.Web.comment;

import com.example.Social.Web.content.Content;
import com.example.Social.Web.content.ContentRepository;
import com.example.Social.Web.reply.ReplyRepository;
import jakarta.transaction.Transactional;
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

    public Comment getSomeComment(CommentID commentId){
        return commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalStateException("There is no Comment with ID = " + commentId)
        );
    }

    public void AddComment(Comment comment){
        if (commentRepository.existsByCommentID_Content(comment.getCommentID().getContent())){
            throw new IllegalStateException("This content id: " +
                    comment.getCommentID().getContent().getContent_id()
                    + " is already used for another content");
        }

        commentRepository.save(comment);

        Content content = contentRepository.findById(comment.getCommentID().getContent().getContent_id())
                .orElseThrow(() -> new IllegalStateException("Content not found"));

        content.setType("comment");
        contentRepository.save(content);
    }

    public String deleteComment(CommentID commentId){
        boolean chk = commentRepository.existsById(commentId);
        if (chk){
            commentRepository.deleteById(commentId);
            return "The Comment with ID = " + commentId + " has been deleted!";
        }

        return "There is not comment with id = " + commentId;
    }

    @Transactional
    public String updateComment(CommentID commentId, String comment_content){
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalStateException("There is no Comment with ID = " + commentId)
        );

        comment.setCommentContent(comment_content);
        return "Action is done";
    }

}
