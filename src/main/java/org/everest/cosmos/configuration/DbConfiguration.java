package org.everest.cosmos.configuration;

import org.everest.cosmos.configuration.db.HibernateConfiguration;
import org.everest.cosmos.configuration.db.HibernateH2Configuration;
import org.everest.cosmos.configuration.db.HibernateMysqlConfiguration;
import org.everest.cosmos.entity.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.everest.cosmos.repository")
public class DbConfiguration {
    @Bean
    public SessionFactory sessionFactory() {
        HibernateConfiguration configuration = new HibernateH2Configuration();

        configuration.configure();

        //ajout des tables
        configuration.addClass(Product.class);
        configuration.addClass(Comment.class);
        configuration.addClass(Customer.class);
        configuration.addClass(Order.class);
        configuration.addClass(OrderLine.class);

        configuration.buildSessionFactory();

        SessionFactory sessionFactory = configuration.sessionFactory();

        return sessionFactory;
    }

}
