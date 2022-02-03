package com.example.springwebproject.controller;


import com.example.springwebproject.dto.ResponseDTO;
import com.example.springwebproject.entities.User;
import com.example.springwebproject.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    public static final String ID = "/{id}";


    /* INJEÇÃO DE DEPENCIA */
    private UserService userService;


    /* LISTAR TODOS -> localhost:8080//users */
    @GetMapping
    public ResponseEntity<ResponseDTO> listAll(){
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            List<User> list = userService.findAll();
            responseDTO.setData(list);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }catch (Exception ex ){
            ex.printStackTrace();
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }

    }



    /* PROCURAR POR ID  -> localhost:8080//users/1 */
   @GetMapping(value = ID)
    public ResponseEntity<ResponseDTO> findById(@PathVariable Long id){
       ResponseDTO responseDTO = new ResponseDTO();


       try {
           User user = userService.findById(id);
           responseDTO.setData(user);
           return new ResponseEntity<>(responseDTO, HttpStatus.OK);

       }catch (Exception ex ){
           ex.printStackTrace();
           responseDTO.setMessage("não encontrado");
           responseDTO.setData(LocalDateTime.now());
           return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
       }

   }

    /* DELETAR -> localhost:8080//users/1 */
   @DeleteMapping(value = ID)
    public ResponseEntity<ResponseDTO> delete(@PathVariable Long id){
       ResponseDTO responseDTO = new ResponseDTO();

       try {
           userService.delete(id);
           responseDTO.setData(id);
           return new ResponseEntity<>(responseDTO, HttpStatus.OK);
       }catch (Exception ex){
           ex.printStackTrace();
           return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);

       }

   }

    /* CRIAR -> localhost:8080//users */
   @PostMapping    /* CRIAR USERS -> localhost:8080//users */
   public ResponseEntity<ResponseDTO> create(@RequestBody User user){
       ResponseDTO responseDTO = new ResponseDTO();

       try {

           userService.create(user);
           URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                   .buildAndExpand(user.getId()).toUri();
           responseDTO.setData(uri);
           return new ResponseEntity<>(responseDTO, HttpStatus.OK);

       }catch (Exception ex ){
           ex.printStackTrace();
           return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
       }

   }

    /* ATUALIZAR -> localhost:8080//users/1 */
   @PutMapping(value = ID)
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable Long id, @RequestBody  User obj){
       ResponseDTO responseDTO = new ResponseDTO();

       try {
           obj.setId(id);
           User newUser = userService.update(id, obj);
           responseDTO.setData(newUser);
           return new ResponseEntity<>(responseDTO, HttpStatus.OK);

       }catch (Exception ex){
           ex.printStackTrace();
           return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
       }

   }





}
