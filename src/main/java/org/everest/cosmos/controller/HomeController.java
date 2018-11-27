package org.everest.cosmos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("index")
    @ResponseBody
    public ModelAndView Index(){
        return new ModelAndView("home/index")
                .addObject("message","Test de Spring MVC par Yvan de ICT");
    }
}
