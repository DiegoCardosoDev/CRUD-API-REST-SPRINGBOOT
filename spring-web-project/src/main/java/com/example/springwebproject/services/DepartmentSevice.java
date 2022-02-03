package com.example.springwebproject.services;


import com.example.springwebproject.entities.Department;
import com.example.springwebproject.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentSevice {

    @Autowired
    private DepartmentRepository repository;

    public List<Department> findAll(){
        return repository.findAll();
    }
}
