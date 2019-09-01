package net.orekyuu.shop.web.presentation.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.orekyuu.shop.core.domain.model.product.ProductImage;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ProductImageJsonSerializer extends JsonSerializer<ProductImage> {
    @Override
    public void serialize(ProductImage value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // 画面によってサムネ用などを使い分けたいケースが考えられるのでオブジェクトにしておく
        gen.writeStartObject();
        gen.writeStringField("url", value.url());
        gen.writeEndObject();
    }
}
