package com.example.demo_boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;

@NoRepositoryBean
public interface ExtendedRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    @Query(value="select * from ?2  where id=?1",nativeQuery = true)
    T findOneObject(@Param("id") Long id, @Param("tableName") String tableName);
}
