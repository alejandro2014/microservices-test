package com.kairos.zaratest.controllers;

import com.kairos.zaratest.domain.PriceInformationResponse;
import com.kairos.zaratest.service.ZaraService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ZaraControllerTest {
    @Mock
    private ZaraService zaraService;

    @InjectMocks
    private ZaraController zaraController;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(zaraController).build();
    }

    @Test
    public void getPriceInformation_returnsCorrectData() throws Exception {
        //var priceInformationResponse = new PriceInformationResponse();

        //when(zaraService.getPriceInformation(anyString(), anyString(), anyInt())).thenReturn(priceInformationResponse);

        mockMvc.perform(
                get("/priceinfo")
                        .param("date", "2020-06-14-00.00.00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'message':'ok'}"));
    }

    /*
        a. Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        b. Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        c. Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        d. Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
        e. Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
     */
}
