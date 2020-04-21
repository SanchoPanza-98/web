package ru.omsu.imit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/api")
    public String mainPage(){
        return "mainPageIndex";
    }

    @RequestMapping("/api/profile")
    public String profilePage(){
        return "profilePage";
    }

    @RequestMapping("/api/product")
    public String addProductPage() {
        return "product";
    }

    @RequestMapping("/api/buyer")
    public String registerPage() {
        return "buyer";
    }
}
