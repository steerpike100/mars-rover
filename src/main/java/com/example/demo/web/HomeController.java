package com.example.demo.web;

import com.example.demo.repository.MarsRoverApiService;
import com.example.demo.response.MarsRoverApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService roverService;

    @GetMapping("/")
    public String getHomeView (ModelMap model) {
        MarsRoverApiResponse roverData = roverService.getRoverData("opportunity");
        model.put("roverData", roverData);

        return "index";
    }

    @PostMapping("/")
    public String postHomeView (ModelMap model, @RequestParam String marsApiRoverData) {
        MarsRoverApiResponse roverData = roverService.getRoverData(marsApiRoverData);
        model.put("roverData", roverData);

        return "index";
    }
}