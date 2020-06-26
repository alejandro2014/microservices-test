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
    public void getPriceInformation_returnsCorrectData_test1() throws Exception {
        mockMvc.perform(
                get("/priceinfo")
                        .param("date", "2020-06-14-00.00.00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'productId':'35455','brandId':'1','priceList':1,'startDate':'2020-06-14-00.00.00','endDate':'2020-12-31-23.59.59'}"));
    }

    @Test
    public void getPriceInformation_returnsCorrectData_test2() throws Exception {
        mockMvc.perform(
                get("/priceinfo")
                        .param("date", "2020-06-14-16.00.00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'productId':'35455','brandId':'1','priceList':1,'startDate':'2020-06-14-00.00.00','endDate':'2020-12-31-23.59.59'}"));
    }

    @Test
    public void getPriceInformation_returnsCorrectData_test3() throws Exception {
        mockMvc.perform(
                get("/priceinfo")
                        .param("date", "2020-06-14-21.00.00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'productId':'35455','brandId':'1','priceList':1,'startDate':'2020-06-14-00.00.00','endDate':'2020-12-31-23.59.59'}"));
    }

    @Test
    public void getPriceInformation_returnsCorrectData_test4() throws Exception {
        mockMvc.perform(
                get("/priceinfo")
                        .param("date", "2020-06-15-10.00.00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'productId':'35455','brandId':'1','priceList':1,'startDate':'2020-06-14-00.00.00','endDate':'2020-12-31-23.59.59'}"));
    }

    @Test
    public void getPriceInformation_returnsCorrectData_test5() throws Exception {
        mockMvc.perform(
                get("/priceinfo")
                        .param("date", "2020-06-14-21.00.00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'productId':'35455','brandId':'1','priceList':1,'startDate':'2020-06-14-00.00.00','endDate':'2020-12-31-23.59.59'}"));
    }
}
