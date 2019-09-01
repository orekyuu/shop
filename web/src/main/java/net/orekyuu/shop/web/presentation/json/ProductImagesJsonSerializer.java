package net.orekyuu.shop.web.presentation.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.orekyuu.shop.core.domain.model.product.ProductImage;
import net.orekyuu.shop.core.domain.model.product.ProductImages;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.stream.Collectors;

@JsonComponent
public class ProductImagesJsonSerializer extends JsonSerializer<ProductImages> {

    @Override
    public void serialize(ProductImages value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        for (ProductImage image : value.stream().collect(Collectors.toList())) {
            gen.writeObject(image);
        }
        gen.writeEndArray();
    }
}
