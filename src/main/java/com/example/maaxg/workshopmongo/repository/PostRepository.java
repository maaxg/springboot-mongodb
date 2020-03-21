package com.example.maaxg.workshopmongo.repository;

import com.example.maaxg.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
                                                //Classe         //tipo do ID
public interface PostRepository extends MongoRepository<Post, String> {
}
