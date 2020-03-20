package com.example.maaxg.workshopmongo.services;

import com.example.maaxg.workshopmongo.domain.User;
import com.example.maaxg.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//para mostrar que ele vai ser injetado
@Service
public class UserService {
    //injeção de dependencia automatica do spring
    @Autowired
    public UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

}
