package com.example.Social.Web.reaction;

import com.example.Social.Web.comment.Comment;
import com.example.Social.Web.comment.CommentRepository;
import com.example.Social.Web.content.Content;
import com.example.Social.Web.content.ContentRepository;
import com.example.Social.Web.post.Post;
import com.example.Social.Web.post.PostRepository;
import com.example.Social.Web.reply.Reply;
import com.example.Social.Web.reply.ReplyRepository;
import com.example.Social.Web.user.User;
import com.example.Social.Web.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReactionService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private ContentRepository contentRepository;
    public final ReactionRepository reactionRepository;
    @Autowired
    public ReactionService(ReactionRepository reactionRepository){
        this.reactionRepository = reactionRepository;
    }

    public List<Reaction> getAllReactions(){
        return reactionRepository.findAll();
    }

    public Reaction getSomeReaction(ReactionID reaction_id){
        return reactionRepository.findById(reaction_id).orElseThrow(
                () -> new IllegalStateException("There is no Reaction with ID = " + reaction_id)
        );
    }

    public Reaction addReaction(Long userId, Reaction reaction, String type){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("There is no user with this ID")
        );

        ReactionID reactionID = new ReactionID(user, reaction.getReactionID().getContent());
        reaction.setReactionID(reactionID);
        reaction.setReactionType(ReactionType.valueOf(type.toUpperCase()));

        Content content = contentRepository.findById(reaction.getReactionID().getContent().getContentId()).orElseThrow(
                () -> new IllegalStateException("There is no Content with this ID")
        );

        if (Objects.equals(content.getType(), "post")){
            Post post = postRepository.findByPostID_Content_ContentId(content.getContentId());
            List<Reaction> reactions = post.getReactions();
            reactions.add(reaction);
            post.setReactions(reactions);
        }

        else if (Objects.equals(content.getType(), "comment")){
            Comment comment = commentRepository.findByCommentID_Content_ContentId(content.getContentId());
            List<Reaction> reactions = comment.getReactions();
            reactions.add(reaction);
            comment.setReactions(reactions);
        }
        else {
            Reply reply = replyRepository.findByReplyID_Content_ContentId(content.getContentId());
            List<Reaction> reactions = reply.getReactions();
            reactions.add(reaction);
            reply.setReactions(reactions);
        }

        return reactionRepository.save(reaction);
    }

    public String deleteReaction(ReactionID reaction_id){
        boolean chk = reactionRepository.existsById(reaction_id);
        if (chk){
            reactionRepository.deleteById(reaction_id);
            return "The Reaction with ID = " + reaction_id + " has been deleted!";
        }

        return "Action is Done";
    }

    @Transactional
    public String updateReaction(ReactionID reactionID, ReactionType reaction_type){
        Reaction reaction = reactionRepository.findById(reactionID).orElseThrow(
                () -> new IllegalStateException("There is no Reaction with ID = " + reactionID)
        );

        reaction.setReactionType(reaction_type);
        return "Action is done";
    }
}
