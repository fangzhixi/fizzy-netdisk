package com.fizzy.controller;

import com.fizzy.service.ISlaveService;
import com.fizzy.service.impl.SlaveServiceimpl;
import com.fizzy.util.sdk.Autograph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class SlaveController {

    @Autowired
    private SlaveServiceimpl slaveServiceimpl;

    @ResponseBody
    @RequestMapping(value = "/slaveRegister", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    public String slaveRegister(@RequestHeader(value = "Authorization", required = true) String authorization,
                                @RequestParam(value = "totalSpace", required = true, defaultValue = "0") Long totalSpace,
                                @RequestParam(value = "usedSpace", required = true, defaultValue = "0") Long usedSpace) {

        Date now = new Date();
        System.out.printf("\ntotalSpace:%s usedSpace:%s 收到从机注册请求: \n", totalSpace, usedSpace);

        Autograph autograph = new Autograph(authorization);

        Map<String, Object> jsonMap = new HashMap<String, Object>();


        if (!autograph.slaveInvoice()) {
            jsonMap.put("code", 1015);
            jsonMap.put("message", "从机注册失败(密钥无效)");
            return new Gson().toJson(jsonMap);
        }
        System.out.println("autograph: " + autograph.toString());
        //生成UUID
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);

        slaveServiceimpl.insertSlave(uuid.toString(),
                autograph.getAddress(),
                totalSpace,
                usedSpace,
                autograph.getMasterKey(),
                now,
                now);

        jsonMap.put("code", 0);
        jsonMap.put("message", "从机注册成功");
        jsonMap.put("uuid", uuid.toString());
        return new Gson().toJson(jsonMap);
    }
}
