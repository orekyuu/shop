package net.orekyuu.shop.web.presentation.web;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.orekyuu.shop.web.infrastructure.security.ShopUserDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.StreamSupport;

public class FrontInitialData {

    private Map<String, Object> data = new HashMap<>();
    private ObjectMapper mapper;

    public FrontInitialData(ShopUserDetails user, ObjectMapper objectMapper) {
        mapper = objectMapper;
        addSimpleObject("currentUser", model -> {
            if (user != null) {
                model.put("id", user.accountId().value());
            }
        });
    }

    @JsonGetter
    public Map<String, Object> getData() {
        return data;
    }

    public void addJsonObject(String key, Object jsonValue) {
        data.put(key, jsonValue);
    }

    public <E extends Exception> void addSimpleObject(String fieldName, SimpleJsonObjectBuilder<E> builder) throws E {
        HashMap<String, String> map = new HashMap<>();
        builder.build(map);
        addJsonObject(fieldName, map);
    }

    public String toJsonString() throws JsonProcessingException {
        return mapper.writeValueAsString(data);
    }

    @FunctionalInterface
    interface SimpleJsonObjectBuilder<E extends Exception> {

        void build(Map<String, String> json) throws E;
    }
}
