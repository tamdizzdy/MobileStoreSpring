package com.wfh.mobilestorespring.validator;

import com.wfh.mobilestorespring.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class ProductValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName","NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "unitPrice","NotEmpty");
        if(product.getUnitPrice() != null){
            try {
                Integer.parseInt(product.getUnitPrice());
            }catch (NumberFormatException e){
                errors.rejectValue("unitPrice", "NotNumber");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "unitInStock","NotEmpty");
        if(product.getUnitInStock() != null){
            try {
                Integer.parseInt(product.getUnitInStock());
            }catch (NumberFormatException e){
                errors.rejectValue("unitInStock", "NotNumber");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer","NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category","NotEmpty");
        if(product.getImg().isEmpty())
            errors.rejectValue("img","File");
    }
}
