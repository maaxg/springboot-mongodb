package com.example.maaxg.workshopmongo.services;

import com.example.maaxg.workshopmongo.domain.Post;
import com.example.maaxg.workshopmongo.domain.User;
import com.example.maaxg.workshopmongo.dto.UserDTO;
import com.example.maaxg.workshopmongo.repository.PostRepository;
import com.example.maaxg.workshopmongo.repository.UserRepository;
import com.example.maaxg.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//para mostrar que ele vai ser injetado
@Service
public class PostService {
    //injeção de dependencia automatica do spring
    @Autowired
    public PostRepository repository;


    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }


}
