package org.everest.cosmos.controller;

import org.everest.cosmos.repository.NebularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NebularController {

    private NebularRepository repository;

    public NebularController(NebularRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public ModelAndView list(){
        return new ModelAndView("nebular/list")
                .addObject("nebulars",repository.getData());
    }
}
