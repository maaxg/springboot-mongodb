package com.example.maaxg.workshopmongo.services;

import com.example.maaxg.workshopmongo.domain.User;
import com.example.maaxg.workshopmongo.dto.UserDTO;
import com.example.maaxg.workshopmongo.repository.UserRepository;
import com.example.maaxg.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//para mostrar que ele vai ser injetado
@Service
public class UserService {
    //injeção de dependencia automatica do spring
    @Autowired
    public UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
    public User findById(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
    public User insert(User obj){
        return repository.insert(obj);
    }
    public void delete(String id){
        repository.deleteById(id);
    }
    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }


}
