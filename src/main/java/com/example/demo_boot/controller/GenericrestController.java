package com.example.demo_boot.controller;

import com.example.demo_boot.persistence.BaseC;
import com.example.demo_boot.service.ExService;


import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


@RestController
public class GenericrestController<T extends BaseC> {


    private ExService exService;

    private ObjectMapper objectMapper;

    @Autowired
    public GenericrestController(ExService exService, ObjectMapper objectMapper) {
        this.exService = exService;
        this.objectMapper = objectMapper;
    }


    @PostMapping("/post/{tableName}")
    public void postGenericObject(@RequestBody ObjectNode obj, @PathVariable String tableName) {
        System.out.println("************************************************************");
        try {
            String v = objectMapper.writeValueAsString(obj);
            System.out.println(v);
            String className = "com.example.demo_boot.persistence." + tableName;
            Class c = Class.forName(className);
            T d = (T) objectMapper.readValue(v, c);
            exService.create(d, tableName);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("************************************************************");
    }

    @PostMapping("/postArray/{tableName}")
    public void postGenericArray(@RequestBody ArrayNode obj, @PathVariable String tableName) {
        System.out.println("************************************************************");
        try {

            String className = "com.example.demo_boot.persistence." + tableName;
            Class c = Class.forName(className);
            obj.forEach(e -> {
                try {
                    String v = objectMapper.writeValueAsString(e);
                    T t = (T) objectMapper.readValue(v, c);
                    exService.create(t, tableName);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        System.out.println("************************************************************");
    }


}
