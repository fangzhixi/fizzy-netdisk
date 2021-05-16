package com.fizzy.service;

import com.fizzy.pojo.Slave;
import com.fizzy.pojo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ISlaveService {

    List<Slave> selectSlave(Slave slave);

    Integer insertSlave(Slave slave);

    Integer updateSlave(Slave slave);

    Integer deleteSlave(Integer id);
}
