package net.orekyuu.shop.web.presentation.json;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FormAndValidation<FORM> {
    @JsonProperty("form")
    final FORM form;
    @JsonIgnore
    final BindingResult result;

    public FormAndValidation(FORM form, BindingResult result) {
        this.form = form;
        this.result = result;
    }

    public FormAndValidation(FORM form) {
        this(form, null);
    }

    @JsonProperty("fieldError")
    public Map<String, List<String>> getFieldErrors() {
        if (result == null) {
            return Map.of();
        }

        Map<String, List<String>> errors = new HashMap<>();
        for (FieldError fieldError : result.getFieldErrors()) {
            errors.putIfAbsent(fieldError.getField(), new ArrayList<>());

            List<String> messages = errors.get(fieldError.getField());
            messages.add(fieldError.getDefaultMessage());
        }
        return errors;
    }

    @JsonProperty("globalError")
    public List<String> globalError() {
        if (result == null) {
            return List.of();
        }
        return result.getGlobalErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
    }

    @JsonProperty("hasError")
    public boolean hasError() {
        return result != null && result.hasErrors();
    }
}
