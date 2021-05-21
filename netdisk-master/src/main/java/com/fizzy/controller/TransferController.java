package com.fizzy.controller;

import com.fizzy.pojo.File;
import com.fizzy.pojo.Slave;
import com.fizzy.service.impl.FileServiceimpl;
import com.fizzy.service.impl.SlaveServiceimpl;
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
    @Autowired
    SlaveServiceimpl slaveServiceimpl;

    @RequestMapping(value = "/register")
    public String TransferRegister() {
        return "register.jsp";
    }

    @RequestMapping(value = "/main")
    public String TransferIndex(@RequestParam(value = "token") String token,
                                HttpServletRequest request,
                                Model model) {

        Integer userId = Integer.parseInt(request.getAttribute("user_id").toString());
        List<File> fileList = fileServiceimpl.selectFile(0, 0, userId, "", 0, -1, "", null, null);
        model.addAttribute("file", fileList);
        model.addAttribute("token", token);
        System.out.println(fileList.toString());
        return "index.jsp";
    }

    @RequestMapping(value = "/sort")
    public String TransferSort(@RequestParam(value = "token") String token,
                               @RequestParam(value = "file_type") Integer fileType,
                               @RequestParam(value = "parent_element_id",required = false,defaultValue = "-1") Integer parentElementId,
                               HttpServletRequest request,
                               Model model) {

        Integer userId = Integer.parseInt(request.getAttribute("user_id").toString());
        List<File> fileList = fileServiceimpl.selectFile(0, parentElementId, userId, "", 0, fileType, "", null, null);
        model.addAttribute("file_type", fileType);
        model.addAttribute("subdir", File.getSubDirByFileType(fileType));
        model.addAttribute("file", fileList);
        model.addAttribute("token", token);
        System.out.println("file: " + fileList.toString());
        return "sort.jsp";
    }

    @RequestMapping(value = "/upload")
    public String TransferUpload(@RequestParam(value = "token") String token,
                                 @RequestParam(value = "element_id")Integer elementId,
                                 Model model) {

        List<Slave> slaveList = slaveServiceimpl.selectSlave(null, null, 0L, 0L, null, null, null);
        if (slaveList.size()>0){
            model.addAttribute("slave_address", slaveList.get(0).getAddress() + "/upload");
        }
        model.addAttribute("element_id", elementId);
        model.addAttribute("token", token);

        return "upload.jsp";
    }
}
