package com.example.demo_boot.serviceImpl;

import com.example.demo_boot.dao.ExtendedRepository;
import com.example.demo_boot.service.ExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class GenericServiceImpl implements ExService {


    @Autowired
    private ExtendedRepository extendedRepository;

    @Override
    public void create(Serializable entity, String tableName) {
        System.out.println("----------------------------------Persist Single Entity----------------------------------");
        extendedRepository.save(entity);
    }





}
