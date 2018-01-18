package com.app1.smallApp1.controllers;

import com.app1.smallApp1.models.User;
import com.app1.smallApp1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/")
//    public ModelAndView index(@ModelAttribute User user){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("index");
//        return mv;
//    }
    String index(){
        return "index";
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

    //Mengambil data dari db
    @RequestMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    //save to database dengan fungsi get
    @RequestMapping("/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User x = new User(name, email);
        x.setName(name);
        x.setEmail(email);
        userRepository.save(x);
        return "saved";
    }

    @RequestMapping("/findEmail")
    public @ResponseBody Iterable<User> getByEmail(@RequestParam String email){
        return userRepository.findByEmail(email);
    }

    @RequestMapping("/viewdb")
    public ModelAndView viewDbData(@ModelAttribute User user){
        ModelAndView mv = new ModelAndView("userview");
        //mv.setViewName("userview");
        mv.addObject("user", userRepository.findAll());
        return mv;
    }
}