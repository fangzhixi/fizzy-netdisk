package com.fizzy.service;

import com.fizzy.pojo.Slave;
import com.fizzy.pojo.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ISlaveService {

    List<Slave> selectSlave(String uuid, String address, Long totalSpace, Long usedSpace, String masterKey, Date createTime, Date updateTime);

    Integer insertSlave(String uuid, String address, Long totalSpace, Long usedSpace, String masterKey, Date createTime, Date updateTime);

    Integer updateSlave(String uuid, String address, Long totalSpace, Long usedSpace, String masterKey, Date createTime, Date updateTime);

    Integer deleteSlave(String uuid);
}
