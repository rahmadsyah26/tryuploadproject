package com.app1.smallApp1.controllers;

import com.app1.smallApp1.models.User;
import com.app1.smallApp1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/")
    public ModelAndView index(@ModelAttribute User user){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public String findAll(){
        String[] kata = {"mobil","rumah","hotel"};
        String result = "";

        for(String a : kata){
            result += a + "<br>";
        }
//        for(User ussr : repository.findAll()){
//            result += ussr.toString() + "<br>";
//        }
        return result;
    }

    @RequestMapping("/form")
    public ModelAndView form(@ModelAttribute User user){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("form");
        return mv;
    }

    @RequestMapping("/dataview")
    public ModelAndView dataview(@ModelAttribute User user){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("dataview");
        return mv;
    }
}
