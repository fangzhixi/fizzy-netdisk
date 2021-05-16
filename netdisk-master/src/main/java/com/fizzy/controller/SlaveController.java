package com.fizzy.controller;

import com.fizzy.service.impl.SlaveServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SlaveController {

    @Autowired
    private SlaveServiceimpl slaveServiceimpl;
}
