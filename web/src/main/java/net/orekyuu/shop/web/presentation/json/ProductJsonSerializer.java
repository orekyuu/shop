package net.orekyuu.shop.web.presentation.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.orekyuu.shop.core.domain.model.product.Product;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ProductJsonSerializer extends JsonSerializer<Product> {
    @Override
    public void serialize(Product value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("id", value.id().text());
        gen.writeStringField("name", value.name().text());
        gen.writeNumberField("taxIncludedPrice", value.taxIncludedPrice().value());
        gen.writeObjectField("images", value.images());
        gen.writeObjectField("thumbnail", value.thumbnail());
        gen.writeStringField("description", value.description().text());
        gen.writeStringField("url", "/products/" + value.id().value());
        gen.writeEndObject();
    }
}
