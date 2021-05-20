package com.fizzy.service.impl;

import com.fizzy.mapper.FileMapper;
import com.fizzy.pojo.File;
import com.fizzy.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceimpl implements IFileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public List<File> selectFile(Integer elementId, Integer parentElementId, Integer userId, String fileName, Integer fileSize, Integer fileType, String fileUrl, Date createTime, Date updateTime) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("element_id", elementId);
        map.put("parent_element_id", parentElementId);
        map.put("user_id", userId);
        map.put("file_name", fileName);
        map.put("file_size", fileSize);
        map.put("file_type", fileType);
        map.put("file_url", fileUrl);
        map.put("create_time", createTime);
        map.put("update_time", updateTime);
        return fileMapper.selectFile(map);
    }

    @Override
    public Integer insertFile(Integer elementId, Integer parentElementId, Integer userId, String fileName, Integer fileSize, Integer fileType,  String fileUrl, Date createTime, Date updateTime) {
        Map<String, Object> map = new HashMap<String, Object>();
        return fileMapper.insertFile(map);
    }

    @Override
    public Integer updateFile(Integer elementId, Integer parentElementId, Integer userId, String fileName, Integer fileSize, Integer fileType, String fileUrl, Date createTime, Date updateTime) {
        Map<String, Object> map = new HashMap<String, Object>();

        return fileMapper.updateFile(map);
    }

    @Override
    public Integer deleteFile(Integer elementId) {
        return fileMapper.deleteFile(elementId);
    }
}
