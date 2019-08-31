package net.orekyuu.shop.web.presentation.api.web;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MessageResourceControllerTest extends AbstractRestApiTest {

    @Test
    void メッセージが取れる() throws Exception {
        mockMvc.perform(get("/web/api/messages"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[\'site.title\']").value("Shop Demo"));
    }
}