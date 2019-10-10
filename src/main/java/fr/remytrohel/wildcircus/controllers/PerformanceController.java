package fr.remytrohel.wildcircus.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.remytrohel.wildcircus.entities.Performance;
import fr.remytrohel.wildcircus.repositories.PerformanceRepository;

@Controller
public class PerformanceController {
    
    @Autowired
    private PerformanceRepository performanceRepository;

    @GetMapping("/performances")
    public String browse(Model model) {
        List<Performance> performances = performanceRepository.findAll();
        model.addAttribute("performances", performances);
        return "performance";
    }
}