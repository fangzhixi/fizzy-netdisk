package com.fizzy.mapper;

import com.fizzy.pojo.Slave;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface SlaveMapper {

    List<Slave> selectSlave(Map<String, Object> map);

    Integer insertSlave(Map<String, Object> map);

    Integer updateSlave(Map<String, Object> map);

    Integer deleteSlave(@Param("address") String address);

}
