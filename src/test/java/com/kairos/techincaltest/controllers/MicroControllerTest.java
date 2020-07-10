package com.kairos.techincaltest.controllers;

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
public class MicroControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPriceInformation_returnsCorrectData_test1() throws Exception {
        String jsonResponse = "{'productId':'35455','brandId':'1','priceList':1,'startDate':'2020-06-14-00.00.00','endDate':'2020-12-31-23.59.59'}";
        performGet("2020-06-14-00.00.00", "35455", "1", jsonResponse);
    }

    @Test
    public void getPriceInformation_returnsCorrectData_test2() throws Exception {
        String jsonResponse = "{'productId':'35455','brandId':'1','priceList':1,'startDate':'2020-06-14-00.00.00','endDate':'2020-12-31-23.59.59'}";
        performGet("2020-06-14-16.00.00", "35455", "1", jsonResponse);
    }

    @Test
    public void getPriceInformation_returnsCorrectData_test3() throws Exception {
        String jsonResponse = "{'productId':'35455','brandId':'1','priceList':1,'startDate':'2020-06-14-00.00.00','endDate':'2020-12-31-23.59.59'}";
        performGet("2020-06-14-21.00.00", "35455", "1", jsonResponse);
    }

    @Test
    public void getPriceInformation_returnsCorrectData_test4() throws Exception {
        String jsonResponse = "{'productId':'35455','brandId':'1','priceList':1,'startDate':'2020-06-14-00.00.00','endDate':'2020-12-31-23.59.59'}";
        performGet("2020-06-15-10.00.00", "35455", "1", jsonResponse);
    }

    @Test
    public void getPriceInformation_returnsCorrectData_test5() throws Exception {
        String jsonResponse = "{'productId':'35455','brandId':'1','priceList':1,'startDate':'2020-06-14-00.00.00','endDate':'2020-12-31-23.59.59'}";
        performGet("2020-06-14-21.00.00", "35455", "1", jsonResponse);
    }

    @Test
    public void getPriceInformation_returnsNotFound() throws Exception {
        mockMvc.perform(
                get("/priceinfo")
                        .param("searchDate", "2020-06-14-21.00.00")
                        .param("productId", "85455")
                        .param("brandId", "8"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    private void performGet(String searchDate, String productId, String brandId, String jsonResponse) throws Exception {
        mockMvc.perform(
                get("/priceinfo")
                        .param("searchDate", searchDate)
                        .param("productId", productId)
                        .param("brandId", brandId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));
    }
}
