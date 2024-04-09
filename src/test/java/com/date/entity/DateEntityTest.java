package com.date.entity;

import com.date.controller.DateController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DateController.class)
public class DateEntityTest {
    @MockBean
    private DateEntity dateEntity;

    @MockBean
    private DateController dateController;

    private LocalDate localDate;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void DateEntity () throws Exception{

        localDate = LocalDate.now();
        dateEntity = new DateEntity();
        when(dateController.getDate()).thenReturn(Date.valueOf(localDate));
        mockMvc.perform(get("/date"))
                .andExpect(status().isOk())
                        .andExpect(jsonPath("$").value(localDate.toString().toString()));
        Assertions.assertEquals(localDate.getYear(),2024);

    }
}
