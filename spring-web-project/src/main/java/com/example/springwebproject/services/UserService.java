package com.example.springwebproject.services;

import com.example.springwebproject.entities.User;
import com.example.springwebproject.repositories.UserRepository;
import com.example.springwebproject.services.exeptions.ObjectNotFoudExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //procurar por id
    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() ->
                new ObjectNotFoudExeption("objeto não encontrado Id: " + id
                        + " tipo: " + User.class.getName()));//se o ojjeto não for encotrado retorna nulo
    }



    //listar todos
    public List<User> findAll() {
        return userRepository.findAll();

    }

    //delete
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    //create
    public User create(User obj) {
        obj.setId(null);
        return userRepository.save(obj);
    }

    //update
    public User update(Long id, User obj){
        User newUser = findById(id);

        newUser.setName(obj.getName());
        newUser.setEmail(obj.getEmail());
        newUser.setDepartament(obj.getDepartament());
        return userRepository.save(newUser);
    }








}
