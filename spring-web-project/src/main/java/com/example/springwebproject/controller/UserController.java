package com.example.springwebproject.controller;


import com.example.springwebproject.entities.User;
import com.example.springwebproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    public static final String ID = "/{id}";


    /* INJEÇÃO DE DEPENCIA */
    @Autowired
    private UserService userService;


    /* LISTAR TODOS -> localhost:8080//users */
    @GetMapping
    public ResponseEntity<List<User>> listAll(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }



    /* PROCURAR POR ID  -> localhost:8080//users/1 */
   @GetMapping(value = ID)
    public ResponseEntity<User> findById(@PathVariable Long id){
       User user = userService.findById(id);
       return ResponseEntity.ok().body(user);
   }

    /* DELETAR -> localhost:8080//users/1 */
   @DeleteMapping(value = ID)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent()
                .build();
   }

    /* CRIAR -> localhost:8080//users */
   @PostMapping    /* CRIAR USERS -> localhost:8080//users */
   public ResponseEntity<User> create(@RequestBody User user){
       userService.create(user);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
               .buildAndExpand(user.getId()).toUri();
       return ResponseEntity.created(uri).build();

   }

    /* ATUALIZAR -> localhost:8080//users/1 */
   @PutMapping(value = ID)
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody  User obj){
       obj.setId(id);
       User newUser = userService.update(id, obj);
       return ResponseEntity.ok().body(newUser);

   }





}
