package com.example.maaxg.workshopmongo.resources;

import com.example.maaxg.workshopmongo.domain.User;
import com.example.maaxg.workshopmongo.dto.UserDTO;
import com.example.maaxg.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
                                                    //UserDTO::new pode ser utilizado o metodo referencia nesse caso
        List<UserDTO> listDTO = list.stream().map(x -> new  UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
