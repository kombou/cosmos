package org.everest.cosmos.repository.implementation;

import org.everest.cosmos.entity.Product;
import org.everest.cosmos.repository.contract.IProductRepository;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class ProductRepository extends Repository<Product,Integer> implements IProductRepository {

    public ProductRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
        initialize();
    }

    public void initialize(){
        Product product = new Product();
        product.setName("Ordinateurs");
        product.setPrice(new BigDecimal(150000));
        product.setInStock(true);

        this.Save(product);
    }


}
