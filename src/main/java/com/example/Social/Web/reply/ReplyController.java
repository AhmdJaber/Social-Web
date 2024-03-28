package com.example.Social.Web.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ReplyController {
    @Autowired
    private ReplyRepository replyRepository;

    @GetMapping("allReplies")
    public List<Reply> getReplies(){
        return replyRepository.findAll();
    }

    @PostMapping("addReply")
    public Reply addReply(@RequestBody Reply reply){
        return replyRepository.save(reply);
    }
}
