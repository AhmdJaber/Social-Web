package com.example.Social.Web.content;

import com.example.Social.Web.user.User;
import jakarta.persistence.Entity;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @GetMapping("allContents")
    public List<Content> getContents(){
        return contentService.getAllContents();
    }

    @GetMapping("getContent/{ContentID}")
    public Content getContent(@PathParam("ContentID") Long content_id){
        return contentService.getSomeContent(content_id);
    }

    @PostMapping("addContent")
    public Content addContent(@RequestBody Content content){
        return contentService.addContent(content);
    }

    @DeleteMapping("Delete/{ContentID}")
    public String deleteContent(@PathVariable("ContentID") Long id){
        return contentService.deleteContent(id);
    }
}
