package com.example.demo_boot.service;

import com.example.demo_boot.persistence.BaseC;

import java.io.Serializable;
import java.util.List;

public interface ExService<T extends Serializable> {
    void create(T entity, String tableName);


}
