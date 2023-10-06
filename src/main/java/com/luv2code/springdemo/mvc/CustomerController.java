package com.luv2code.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController
{
    /*
    * +----------------------------------------------------+
    * | ADD @INITBINDER TO PROCESS DATA BEFORE THE REQUEST |
    * +----------------------------------------------------+
    *
    * This annotation let us receive the data of a request
    * and do things with it before it reach the method of the request.
    *
    * This method will be called for every web request into this controller and
    * it will trim the strings.
    * */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
        /*
        * This method remove the white space in the sides and if the constructor
        * has the true value as argument it will return null if the value only has
        * white spaces.
        * */
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        /*
        * Then, we will register that custom editor in the DataBinder.
        *
        * I tell to the String class to use this StringTimmerEditor that I've just created.
        * */
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

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
