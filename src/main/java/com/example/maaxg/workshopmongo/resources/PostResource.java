package com.example.maaxg.workshopmongo.resources;

import com.example.maaxg.workshopmongo.domain.Post;
import com.example.maaxg.workshopmongo.domain.User;
import com.example.maaxg.workshopmongo.dto.UserDTO;
import com.example.maaxg.workshopmongo.services.PostService;
import com.example.maaxg.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }


}
