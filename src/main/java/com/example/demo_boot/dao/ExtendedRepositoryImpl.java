package com.example.demo_boot.dao;

import java.io.Serializable;


public class ExtendedRepositoryImpl<T, ID extends Serializable>
{
        /* extends SimpleJpaRepository<T, ID> implements ExtendedRepository<T, ID> {

    private EntityManager entityManager;

    public ExtendedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }*/
}
