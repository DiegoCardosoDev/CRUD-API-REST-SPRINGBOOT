package com.example.springwebproject.controller;


import com.example.springwebproject.entities.Department;
import com.example.springwebproject.services.DepartmentSevice;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/department")
public class DepartmentController {



    private DepartmentSevice sevice;

    /*LISTAR OS DEPARTAMENTOS*/
    @GetMapping
    public ResponseEntity<List<Department>> findAll(){
        List<Department> result = sevice.findAll();
        return ResponseEntity.ok().body(result);

    }

}
