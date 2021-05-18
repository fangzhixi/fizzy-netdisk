package com.fizzy.service.impl;

import com.fizzy.mapper.SlaveMapper;
import com.fizzy.pojo.Slave;
import com.fizzy.service.ISlaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SlaveServiceimpl implements ISlaveService {

    @Autowired
    SlaveMapper slaveMapper;

    @Override
    public List<Slave> selectSlave(String address, Long usedSpace, Long freeSpace, String masterKey, Date createTime, Date updateTime) {
        Slave slave = new Slave()
                .buildAddress(address)
                .buildUsedSpace(usedSpace)
                .buildFreeSpace(freeSpace)
                .buildMasterKey(masterKey)
                .buildCreateTime(createTime)
                .buildUpdateTime(updateTime)
                .build();
        return slaveMapper.selectSlave(slave.getMap());
    }

    @Override
    public Integer insertSlave(String address, Long usedSpace, Long freeSpace, String masterKey, Date createTime, Date updateTime) {
        Slave slave = new Slave()
                .buildAddress(address)
                .buildUsedSpace(usedSpace)
                .buildFreeSpace(freeSpace)
                .buildMasterKey(masterKey)
                .buildCreateTime(createTime)
                .buildUpdateTime(updateTime)
                .build();
        return slaveMapper.insertSlave(slave.getMap());
    }

    @Override
    public Integer updateSlave(String address, Long usedSpace, Long freeSpace, String masterKey, Date createTime, Date updateTime) {
        Slave slave = new Slave()
                .buildAddress(address)
                .buildUsedSpace(usedSpace)
                .buildFreeSpace(freeSpace)
                .buildMasterKey(masterKey)
                .buildCreateTime(createTime)
                .buildUpdateTime(updateTime)
                .build();
        return slaveMapper.updateSlave(slave.getMap());
    }

    @Override
    public Integer deleteSlave(String address) {
        return slaveMapper.deleteSlave(address);
    }
}
