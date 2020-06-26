package com.kairos.zaratest.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ZaraControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPriceInformation_returnsCorrectData() throws Exception {
        mockMvc.perform(
                get("/priceinfo")
                        .param("date", "2020-06-14-00.00.00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'productId':'35455','brandId':'1','priceList':1,'startDate':'2020-06-14-00.00.00','endDate':'2020-12-31-23.59.59'}"));
    }

    /*
        a. Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        b. Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        c. Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        d. Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
        e. Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
     */
}
