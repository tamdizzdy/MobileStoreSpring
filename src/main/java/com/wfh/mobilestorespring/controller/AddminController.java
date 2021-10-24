package com.wfh.mobilestorespring.controller;

import com.wfh.mobilestorespring.model.Product;
import com.wfh.mobilestorespring.services.ProductServices;
import com.wfh.mobilestorespring.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AddminController {
    @Autowired
    private ProductServices productServices;
    @Autowired
    private ProductValidator productValidator;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping(value = {"/addProduct"})
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product, Model model, BindingResult bindingResult) {
        // valid
        productValidator.validate(product , bindingResult);
        if(bindingResult.hasErrors()){
            return "addProduct";
        }

        if (!product.getImg().isEmpty()) {
            try {
                product.setImage(product.getImg().getBytes());
            } catch (IOException e) {
                model.addAttribute("noti", "Upload File Error - File Not Found");
                return "addProduct";
            }
        }


        if (productServices.addProduct(product) != null)
            model.addAttribute("noti", "Add Product Success");
        else
            model.addAttribute("noti", "Add Product Fail");
        return "addProduct";
    }




}
