package com.fizzy.service;

import com.fizzy.pojo.Slave;
import com.fizzy.pojo.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ISlaveService {

    List<Slave> selectSlave(String address, Long usedSpace, Long freeSpace, String masterKey, Date createTime,Date updateTime);

    Integer insertSlave(String address, Long usedSpace, Long freeSpace, String masterKey, Date createTime,Date updateTime);

    Integer updateSlave(String address, Long usedSpace, Long freeSpace, String masterKey, Date createTime,Date updateTime);

    Integer deleteSlave(String address);
}
