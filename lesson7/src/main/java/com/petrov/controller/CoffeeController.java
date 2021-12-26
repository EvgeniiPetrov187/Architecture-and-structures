package com.petrov.controller;

import com.petrov.persist.Coffee;
import com.petrov.persist.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {


    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping("/all")
    public String listCoffee(Model model) {
        model.addAttribute("coffees", coffeeRepository.findAll());
        return "coffees";
    }

    @GetMapping("/new")
    public String newCoffeeForm(Model model) {
        model.addAttribute("coffee", new Coffee());
    return "new_coffee";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("coffee", coffeeRepository.findById(id));
        return "new_coffee";
    }

    @PostMapping
    public String update(@Valid Coffee coffee, BindingResult result){
        if (result.hasErrors()){
            return "new_coffee";
        }
        coffeeRepository.update(coffee);
        return "redirect:/coffee";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        model.addAttribute("coffee", coffeeRepository.findById(id));
        coffeeRepository.delete(id);
        return "redirect:/coffees";
    }
}
