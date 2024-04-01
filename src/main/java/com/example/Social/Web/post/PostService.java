package com.example.Social.Web.post;

import com.example.Social.Web.content.Content;
import com.example.Social.Web.content.ContentRepository;
import com.example.Social.Web.user.User;
import com.example.Social.Web.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContentRepository contentRepository;
    private final PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> allPosts(){
        return postRepository.findAll();
    }

    public Post getSomePost(PostID post_id){
        return postRepository.findById(post_id).orElseThrow(
                () -> new IllegalStateException("There is no Post with ID = " + post_id)
        );
    }

    public Post AddPost(Post post, Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("There is no User with ID = " + userId)
        );

        Content newContent= new Content(user, "post");
        contentRepository.save(newContent);
        PostID postID = new PostID(newContent);
        post.setPostID(postID);

        return postRepository.save(post);
    }

    public String deletePost(PostID post_id){
        boolean chk = postRepository.existsById(post_id);
        if (chk){
            postRepository.deleteById(post_id);
            return "The Post with ID = " + post_id + " has been deleted!";
        }

        return "There is not post with id = " + post_id;
    }

    @Transactional
    public String updatePost(PostID post_id, String post_content){
        Post post = postRepository.findById(post_id).orElseThrow(
                () -> new IllegalStateException("There is no Post with ID = " + post_id)
        );

        post.setPost_content(post_content);
        return "Action is done";
    }


}
