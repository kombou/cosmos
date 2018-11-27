package org.everest.cosmos.controller;

import org.everest.cosmos.configuration.db.HibernateConfiguration;
import org.everest.cosmos.configuration.db.HibernateMysqlConfiguration;
import org.everest.cosmos.entity.*;
import org.everest.cosmos.repository.implementation.ProductRepository;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ProductTest {

    public Logger logger = LoggerFactory.getLogger(ProductTest.class);

    @Autowired
    public ProductRepository repository;

    @Test
    public void createTest(){
        HibernateConfiguration configuration = new HibernateMysqlConfiguration();

        configuration.configure();

        configuration.addClass(Product.class);

        configuration.buildSessionFactory();

        SessionFactory sessionFactory = configuration.sessionFactory();

        repository = new ProductRepository(sessionFactory);

        Product p = new Product();
        p.setName("Ordinateurs");
        p.setPrice(new BigDecimal(150000));

        p = repository.Save(p);

        logger.info("Ajout du produit d\'id : " + p.getId());

    }

    @Test
    public void list(){
        HibernateConfiguration configuration = new HibernateMysqlConfiguration();

        configuration.configure();

        configuration.addClass(Product.class);

        configuration.buildSessionFactory();

        SessionFactory sessionFactory = configuration.sessionFactory();

        repository = new ProductRepository(sessionFactory);


        for (Product product : repository.List()) {
            logger.info("Nom du produit d\'id "+ product.getId() + " est : "+ product.getName());
        }
    }
}
