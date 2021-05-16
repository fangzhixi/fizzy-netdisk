package com.fizzy.service.impl;

import com.fizzy.mapper.SlaveMapper;
import com.fizzy.pojo.Slave;
import com.fizzy.service.ISlaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SlaveServiceimpl implements ISlaveService {

    @Autowired
    SlaveMapper slaveMapper;

    public List<Slave> selectSlave(Slave slave) {
        Map<String, Object> map = new HashMap<String,Object>();
        return slaveMapper.selectSlave(map);
    }

    public Integer insertSlave(Slave slave) {
        Map<String, Object> map = new HashMap<String,Object>();
        return slaveMapper.insertSlave(map);
    }

    public Integer updateSlave(Slave slave) {
        Map<String, Object> map = new HashMap<String,Object>();
        return slaveMapper.updateSlave(map);
    }

    public Integer deleteSlave(Integer id) {
        return slaveMapper.deleteSlave(id);
    }
}
