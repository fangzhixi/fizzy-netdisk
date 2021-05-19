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
    public List<Slave> selectSlave(String uuid,String address, Long totalSpace, Long usedSpace, String masterKey, Date createTime, Date updateTime) {
        Slave slave = new Slave()
                .buildUuid(uuid)
                .buildAddress(address)
                .buildTotalSpace(totalSpace)
                .buildUsedSpace(usedSpace)
                .buildMasterKey(masterKey)
                .buildCreateTime(createTime)
                .buildUpdateTime(updateTime)
                .build();
        return slaveMapper.selectSlave(slave.getMap());
    }

    @Override
    public Integer insertSlave(String uuid,String address, Long totalSpace, Long usedSpace, String masterKey, Date createTime, Date updateTime) {
        Slave slave = new Slave().buildAddress(address)
                .buildUuid(uuid)
                .buildAddress(address)
                .buildTotalSpace(totalSpace)
                .buildUsedSpace(usedSpace)
                .buildMasterKey(masterKey)
                .buildCreateTime(createTime)
                .buildUpdateTime(updateTime)
                .build();
        System.out.println("slave" + slave.toString());
        return slaveMapper.insertSlave(slave.getMap());
//        return 0;
    }

    @Override
    public Integer updateSlave(String uuid,String address,Long totalSpace, Long usedSpace, String masterKey, Date createTime, Date updateTime) {
        Slave slave = new Slave()
                .buildUuid(uuid)
                .buildAddress(address)
                .buildTotalSpace(totalSpace)
                .buildUsedSpace(usedSpace)
                .buildMasterKey(masterKey)
                .buildCreateTime(createTime)
                .buildUpdateTime(updateTime)
                .build();
        return slaveMapper.updateSlave(slave.getMap());
    }

    @Override
    public Integer deleteSlave(String uuid) {
        return slaveMapper.deleteSlave(uuid);
    }
}
