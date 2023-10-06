package com.luv2code.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController
{
    @GetMapping("/")
    public String showForm(Model model)
    {
        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/process-form")
    public String processForm(
        /*
        * @Valid tells Spring MVC to perform validation
        *
        * @ModelAttribute tells read the form data from
        * the model attribute customer submitted by
        * the HTML form
        * */
        @Valid @ModelAttribute("customer") Customer customer,
        /*
        * Holds the results of the validation
        * */
        BindingResult bidingResults
    )
    {
        if (bidingResults.hasErrors())
        {
            // Return to the form's view
            return "customer-form";
        }
        else
            return "customer-confirmation";
    }
}
