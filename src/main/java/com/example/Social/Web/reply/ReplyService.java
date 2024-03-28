package com.example.Social.Web.reply;

import com.example.Social.Web.content.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    @Autowired
    private ContentRepository contentRepository;
    private final ReplyRepository replyRepository;
    @Autowired
    public ReplyService(ReplyRepository replyRepository){
        this.replyRepository = replyRepository;
    }

    public List<Reply> getAllReplies(){
        return replyRepository.findAll();
    }

    public Reply getSomeReply(Long reply_id){
        return replyRepository.findById(reply_id).orElseThrow(
                () -> new IllegalStateException("There is no Reply with ID = " + reply_id)
        );
    }

    public void AddReply(Reply reply){
        if (reply.getContent().getType() != null){
            throw new IllegalStateException("This content id: " +
                    reply.getContent().getContent_id()
                    + " is already used for another content");
        }

        reply.setContent(contentRepository.findById(
                        reply.getContent().getContent_id()).orElseThrow(
                        () -> new IllegalStateException("There is not content with this id")
                )
        );
        reply.getContent().setType("reply");
        replyRepository.save(reply);
    }

    public String deleteReply(Long reply_id){
        boolean chk = replyRepository.existsById(reply_id);
        if (chk){
            replyRepository.deleteById(reply_id);
            return "The Reply with ID = " + reply_id + " has been deleted!";
        }

        return "There is not reply with id = " + reply_id;
    }

    public String updateReply(Long reply_id, String reply_content){
        Reply reply = replyRepository.findById(reply_id).orElseThrow(
                () -> new IllegalStateException("There is no Reply with ID = " + reply_id)
        );

        reply.setReply_content(reply_content);
        return "Action is done";
    }
}
