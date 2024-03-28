package com.example.Social.Web.content;

import com.example.Social.Web.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    public final ContentRepository contentRepository;
    @Autowired
    public ContentService(ContentRepository contentRepository){
        this.contentRepository = contentRepository;
    }

    public List<Content> getAllContents(){
        return contentRepository.findAll();
    }

    public Content getSomeContent(Long content_id){
        return contentRepository.findById(content_id).orElseThrow(
                () -> new IllegalStateException("There is no Content with ID = " + content_id)
        );
    }

    public Content addContent(Content content){
        return contentRepository.save(content);
    }

    public String deleteContent(Long content_id){
        boolean chk = contentRepository.existsById(content_id);
        if (chk){
            contentRepository.deleteById(content_id);
            return "The Content with ID = " + content_id + " has been deleted!";
        }

        return "Action is Done";
    }


}
