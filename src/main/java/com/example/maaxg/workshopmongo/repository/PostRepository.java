package com.example.maaxg.workshopmongo.repository;

import com.example.maaxg.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
                                                //Classe         //tipo do ID
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ title : { $regex: ?0, $options: 'i'} }")
    List<Post> findByTitle(String text);
    List<Post> findByTitleContainingIgnoreCase(String text);
}
