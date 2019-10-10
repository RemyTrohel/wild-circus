package fr.remytrohel.wildcircus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.remytrohel.wildcircus.entities.User;
import fr.remytrohel.wildcircus.repositories.UserRepository;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;
    
    @PostMapping("/users")
    public String add(RedirectAttributes redirectAttributes, User user, BindingResult bindingResult) {
        if (userRepository.findByMail(user.getMail()) != null) {
            redirectAttributes.addFlashAttribute("mailUsed", "Mail already used !");
            bindingResult.addError(new ObjectError("mail", "Mail already used"));
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", "Registration failure !");
        }
        else {
            userRepository.save(user);
            redirectAttributes.addFlashAttribute("message", "Registration success !");
        }
        return "redirect:/users/register";
    }

    @GetMapping("/users/register")
    public String register(
        Model model,
        @ModelAttribute("mailUsed") String mailUsed,
        @ModelAttribute("message") String message
    ) {
        if (!mailUsed.equals("")) {
            model.addAttribute("mailUsed", mailUsed);
        }
        if (!message.equals("")) { 
            model.addAttribute("message", message);
        }
        return "registration";
    }
}