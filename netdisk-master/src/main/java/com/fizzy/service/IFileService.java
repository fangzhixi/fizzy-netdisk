package com.fizzy.service;

import com.fizzy.pojo.Slave;

import java.util.Date;
import java.util.List;

public interface IFileService {

    List<Slave> selectFile(Integer elementId, Integer parentElementId, Integer userId, String fileName, Integer fileSize, Date createTime,Date updateTime);

    Integer insertFile(Integer elementId, Integer parentElementId, Integer userId, String fileName, Integer fileSize, Date createTime,Date updateTime);

    Integer updateFile(Integer elementId, Integer parentElementId, Integer userId, String fileName, Integer fileSize, Date createTime,Date updateTime);

    Integer deleteFile(Integer elementId);
}
