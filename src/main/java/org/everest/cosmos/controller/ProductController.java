package org.everest.cosmos.controller;

import org.everest.cosmos.entity.Product;
import org.everest.cosmos.repository.implementation.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping("products")
public class ProductController {

    private ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("list")
    public ModelAndView list(){
        return new ModelAndView("product/index")
                .addObject("products",repository.List());
    }
}
