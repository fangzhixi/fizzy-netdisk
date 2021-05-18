package com.fizzy.service.impl;

import com.fizzy.pojo.Slave;
import com.fizzy.service.IFileService;

import java.util.Date;
import java.util.List;

public class FileServiceimpl implements IFileService {
    @Override
    public List<Slave> selectFile(Integer elementId, Integer parentElementId, Integer userId, String fileName, Integer fileSize, Date createTime, Date updateTime) {
        return null;
    }

    @Override
    public Integer insertFile(Integer elementId, Integer parentElementId, Integer userId, String fileName, Integer fileSize, Date createTime, Date updateTime) {
        return null;
    }

    @Override
    public Integer updateFile(Integer elementId, Integer parentElementId, Integer userId, String fileName, Integer fileSize, Date createTime, Date updateTime) {
        return null;
    }

    @Override
    public Integer deleteFile(Integer elementId) {
        return null;
    }
}
