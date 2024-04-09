package com.date.controller;


import com.date.entity.DateEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class DateController {



    @GetMapping("/date")
    public Date getDate() {
        DateEntity date = new DateEntity();
        return date.getDate();
    }


}
