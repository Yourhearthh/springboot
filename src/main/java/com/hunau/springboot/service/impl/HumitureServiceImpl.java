package com.hunau.springboot.service.impl;

import com.hunau.springboot.domain.Humiture;
import com.hunau.springboot.mapper.HumitureMapper;
import com.hunau.springboot.service.IHumitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cx
 * @Time 2020/6/28 15:23
 * @Description 温湿度采集 业务层实现
 */
@Service
public class HumitureServiceImpl implements IHumitureService {

    @Autowired
    private HumitureMapper humitureMapper;

    /**
     * @description 温湿度采集 查询
     *
     * @param
     * @return 温湿度采集 列表
     */
    @Override
    public List<Humiture> listHumiture()
    {
        return humitureMapper.listHumiture();
    }
    /**
     * @description 温湿度采集 存库
     *
     * @param
     * @return 温湿度采集 存库
     */
    @Override
    public int insertData(Humiture humiture){
        return humitureMapper.insertData(humiture);
    }
}
