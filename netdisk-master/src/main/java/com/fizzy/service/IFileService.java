package com.fizzy.service;

import com.fizzy.pojo.File;
import com.fizzy.pojo.Slave;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IFileService {

    List<File> selectFile(Integer elementId, Integer parentElementId, Integer userId, String fileName, Integer fileSize, Integer fileType, String fileUrl, Date createTime, Date updateTime);

    Integer insertFile(Integer elementId, Integer parentElementId, Integer userId, String fileName, Integer fileSize,Integer fileType, String fileUrl, Date createTime, Date updateTime);

    Integer updateFile(Integer elementId, Integer parentElementId, Integer userId, String fileName, Integer fileSize,Integer fileType, String fileUrl, Date createTime, Date updateTime);

    Integer deleteFile(Integer elementId);
}
