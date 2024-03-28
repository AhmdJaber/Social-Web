package com.example.Social.Web.content;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Content")
public class ContentController {
    @Autowired
    private ContentRepository contentRepository;

    @GetMapping("allContents")
    public List<Content> getContents(){
        return contentRepository.findAll();
    }

    @PostMapping("addContent")
    public Content addContent(@RequestBody Content content){
        return contentRepository.save(content);
    }
}
