package com.example.Social.Web.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Post")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("allPosts")
    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    @PostMapping("addPost")
    public Post addPost(@RequestBody Post post){
        return postRepository.save(post);
    }
}
