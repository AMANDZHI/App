package com.company.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionSupplier {
    private EntityManagerFactory entityManagerFactory;

    {
        entityManagerFactory = createEntityManagerFactory();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            return createEntityManagerFactory();
        } else {
            return entityManagerFactory;
        }
    }

    private EntityManagerFactory createEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("hibernateJPA");
    }
}