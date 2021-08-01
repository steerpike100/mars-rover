package com.example.demo.web;

import com.example.demo.repository.MarsRoverApiService;
import com.example.demo.response.MarsRoverApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService roverService;

    @GetMapping("/")
    public String getHomeView(ModelMap model) {
        MarsRoverApiResponse roverData =  roverService.getRoverData("curiosity");
        model.put("roverData", roverData);
        return "index";
    }
}
