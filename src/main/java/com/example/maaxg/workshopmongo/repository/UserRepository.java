package com.example.maaxg.workshopmongo.repository;

import com.example.maaxg.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
                                                //Classe         //tipo do ID
public interface UserRepository extends MongoRepository<User, String> {
}
