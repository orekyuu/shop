package net.orekyuu.shop.web.presentation;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;


@ControllerAdvice
public class BaseControllerAdvice {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }
}
