package com.fizzy.mapper;

import com.fizzy.pojo.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface FileMapper {

    List<File> selectFile(Map<String, Object> map);

    Integer insertFile(Map<String, Object> map);

    Integer updateFile(Map<String, Object> map);

    Integer deleteFile(@Param("element_id") Integer elementId);

}
