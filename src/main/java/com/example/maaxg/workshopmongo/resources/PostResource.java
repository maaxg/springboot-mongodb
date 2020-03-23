package com.example.maaxg.workshopmongo.resources;

import com.example.maaxg.workshopmongo.domain.Post;
import com.example.maaxg.workshopmongo.domain.User;
import com.example.maaxg.workshopmongo.dto.UserDTO;
import com.example.maaxg.workshopmongo.resources.util.URL;
import com.example.maaxg.workshopmongo.services.PostService;
import com.example.maaxg.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
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
    @RequestMapping(value ="/titlesearch", method = RequestMethod.GET)
                                            //Para o endpoint identificar o parametro q vc passar na URL
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value ="/titlesearchmg", method = RequestMethod.GET)
    //Para o endpoint identificar o parametro q vc passar na URL
    public ResponseEntity<List<Post>> findByTitleMongo(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitleMong(text);
        return ResponseEntity.ok().body(list);
    }
    @RequestMapping(value ="/fullsearch", method = RequestMethod.GET)
    //Para o endpoint identificar o parametro q vc passar na URL
    public ResponseEntity<List<Post>> fullSearch
            (@RequestParam(value = "text", defaultValue = "") String text,
             @RequestParam(value = "minDate", defaultValue = "") String minDate,
             @RequestParam(value = "maxDate", defaultValue = "") String maxDate){
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }

}
