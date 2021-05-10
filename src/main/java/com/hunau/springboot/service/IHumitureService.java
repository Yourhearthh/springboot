package com.hunau.springboot.service;

import com.hunau.springboot.domain.Humiture;

import java.util.List;

/**
 * @author cx
 * @Time 2020/6/28 15:22
 * @Description 温湿度采集 业务层接口
 */
public interface IHumitureService {
    /**
     * @description 温湿度采集 查询
     *
     * @param
     * @return 温湿度采集 列表
     */
    public List<Humiture> listHumiture();
    /**
     * @description 温湿度采集 存库
     *
     * @param
     * @return 温湿度采集 存库
     */
    public int insertData(Humiture humiture);
}
