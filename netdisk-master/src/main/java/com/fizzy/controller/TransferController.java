package com.fizzy.controller;

import com.fizzy.pojo.File;
import com.fizzy.service.impl.FileServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
public class TransferController {

    @Autowired
    FileServiceimpl fileServiceimpl;

    @RequestMapping(value = "/register")
    public String TransferRegister() {
        return "register.jsp";
    }

    @RequestMapping(value = "/main")
    public String TransferIndex(@RequestParam(value = "token") String token,
                                HttpServletRequest request,
                                Model model) {

        Integer userId = Integer.parseInt(request.getAttribute("user_id").toString());
        List<File> fileList = fileServiceimpl.selectFile(0, 0, userId, "", 0, 0, "", null, null);
        model.addAttribute("file", fileList);
        model.addAttribute("token", token);
        System.out.println(fileList.toString());
        return "index.jsp";
    }

    @RequestMapping(value = "/sort")
    public String TransferSort(@RequestParam(value = "token") String token,
            @RequestParam(value = "file_type") Integer fileType,
                               HttpServletRequest request,
                               Model model) {

        Integer userId = Integer.parseInt(request.getAttribute("user_id").toString());
        List<File> fileList = fileServiceimpl.selectFile(0, 0, userId, "", 0, fileType, "", null, null);
        model.addAttribute("file", fileList);
        model.addAttribute("token", token);
        System.out.println(fileList.toString());
        return "sort.jsp";
    }

    @RequestMapping(value = "/upload")
    public String TransferUpload() {
        return "upload.jsp";
    }


}
